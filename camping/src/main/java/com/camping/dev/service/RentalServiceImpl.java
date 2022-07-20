package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.mapper.ReviewMapper;
import com.camping.dev.model.vo.*;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private RentalMapper rentalMapper;
    private GoodsMapper goodsMapper;
    private ReviewMapper reviewMapper;
    private MemberMapper memberMapper;
    private final Logger logger = LoggerFactory.getLogger("RentalServiceImpl's log");


    // 대여 요청
    @Override
    public RentalResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            if(rentalMapper.countingRentInfoByEmail(rentalRequestVO.getId(),
                                                    rentalRequestVO.getEmail()) == 0) {

                rentalRequestVO.setLenderEmail(goodsMapper.getLenderEmail(rentalRequestVO.getId()));
                rentalMapper.insertRentalRequest(rentalRequestVO);
                resultVO.setStatus("6000");

            } else {

                resultVO.setStatus("6002");    // 6002 : 중복 대여 요청

            }

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 수락
    @Override
    public RentalResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.acceptRental(rentalAcceptVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 거절
    @Override
    public RentalResponseVO sendRentalReject(RentalRejectVO rentalRejectVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.rejectRental(rentalRejectVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // 대여 반환
    @Override
    public RentalResponseVO sendRentalReturn(RentalReturnVO rentalReturnVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            // 상품반환
            String lenderEmail = rentalMapper.selectLenderEmail(rentalReturnVO);
            logger.info(lenderEmail);
            rentalMapper.returnRental(rentalReturnVO);
            resultVO.setStatus("6000");

            double grade = getGrade(rentalReturnVO.getReview());
            logger.info(Double.toString(grade));

            reviewMapper.insertReview(rentalReturnVO.getId()
                                    , rentalReturnVO.getEmail()
                                    , (int)Math.round(grade)
                                    , rentalReturnVO.getReview());


            // 유저 평점 갱신
            CalculateUserGradeVO calculateUserGradeVO = memberMapper.selectTradedAndGrade(lenderEmail);
            int traded = calculateUserGradeVO.getTraded();
            double userGrade = calculateUserGradeVO.getGrade();
            double newGrade = ( (traded * userGrade) + rentalReturnVO.getGrade() ) / (traded + 1);
            newGrade = Math.round(newGrade * 10) / 10.0;
            memberMapper.updateTradedAndGrade(lenderEmail, traded + 1, newGrade);


            // 상품 평점 갱신
            CalculateGoodsGradeVO calculateGoodsGradeVO = goodsMapper.selectReviewsAndGrade(rentalReturnVO.getId());
            int reviews = calculateGoodsGradeVO.getReviews();
            double goodsGrade = calculateGoodsGradeVO.getGrade();
            double newGoodsGrade = ( (reviews * goodsGrade) + grade ) / (reviews + 1);
            newGoodsGrade = Math.round(newGoodsGrade * 10) / 10.0;
            goodsMapper.updateNewReviewAndNewGrade(rentalReturnVO.getId(), reviews + 1, newGoodsGrade);

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        }

        return resultVO;

    }


    // API 호출 후 평점 결과 반환
    public double getGrade(String reviewMsg){

        HttpURLConnection conn = null;
        double grade = 0;

        /**
         * 리뷰메세지를 리뷰테이블에 적재
         * 리뷰테이블에 들어가는 평점은 ML 모델 API 에 리뷰메세지를 넣어서 추출한 값
         */

        try {
            URL url = new URL("http://54.180.64.59:5000/predict");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(10000);
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 리뷰메세지 세팅
            JSONObject jsonMsg = new JSONObject();
            jsonMsg.put("text", reviewMsg);
            logger.info(jsonMsg.toString());

            // API 호출
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            bw.write(jsonMsg.toString());
            bw.flush();
            bw.close();

            // 응답 결과 받기
            String result = "";
            if(conn.getResponseCode() == 200) {

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;
                while( (line = br.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                br.close();

            } else {

                // HTTP 에러 메세지 로깅
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while( (line = br.readLine()) != null) {
                    sb.append(line);
                }
                logger.info("error : " + sb.toString());
                br.close();

            }

            // logger.info("result : " + result);
            JSONObject jsonObj = new JSONObject((String) new JSONParser().parse(result));
            // logger.info(jsonObj.getString("grade"));

            grade = Double.parseDouble(jsonObj.getString("grade")) * 5;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return grade;

    }

}
