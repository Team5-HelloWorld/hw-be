package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.mapper.ReviewMapper;
import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.GoodsDetailVO;
import com.camping.dev.model.vo.GoodsInfoVO;
import com.camping.dev.model.vo.GoodsSampleVO;
import com.camping.dev.util.BCryptUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private GoodsMapper goodsMapper;
    private ReviewMapper reviewMapper;
    private RentalMapper rentalMapper;
    private MemberMapper memberMapper;
    private final ClassPathResource mainCsvResource = new ClassPathResource("csv/main_page_data_renew2.csv");
    private final Logger logger = LoggerFactory.getLogger("GoodsServiceImpl's log");

    @Override
    public List<GoodsSampleVO> getSampleList(){

        logger.info("getSampleList called!");

        return goodsMapper.getSampleList();

    }

    // 상품 상세 페이지 로딩
    @Override
    public GoodsDetailVO getGoodsDetail(int id){

        logger.info(Integer.toString(id));

        GoodsDetailVO goodsDetail = new GoodsDetailVO();
        GoodsInfoVO goodsInfo = goodsMapper.getGoodsInfo(id);

        BeanUtils.copyProperties(goodsInfo, goodsDetail);
        goodsDetail.setGoodsInfo("");
        goodsDetail.setReview(reviewMapper.getReview(id));
        goodsDetail.setRentPeriod(rentalMapper.getRentPeriod(id));

        return goodsDetail;

    }

    // 메인 화면 굿즈 데이터 DB 에 적재
    @PostConstruct
    public void readMainDataCsvAndInsert() {
        BufferedReader goodsReader = null;

        int count = goodsMapper.getCount();

        // 초기 Data 가 없을 때 csv read
        if (count == 0) {

            try {
                goodsReader = Files.newBufferedReader(Paths.get(mainCsvResource.getURI()));
                String goodsLine = "";

                // read first line(column)
                String tmpGoods = goodsReader.readLine();

                while ((goodsLine = goodsReader.readLine()) != null) {

                    String goodsDetail[] = goodsLine.split(",");
                    String prdId = goodsDetail[0];
                    String email = goodsDetail[1];
                    String category = goodsDetail[2];
                    String name = goodsDetail[3];
                    int price = Integer.parseInt(goodsDetail[4]);
                    String imageUrl = goodsDetail[6];

                    goodsMapper.insertInitData(prdId, email, category, name, price, imageUrl);

                    // 초기 회원데이터 적재
                    Member member = new Member();
                    member.setEmail(goodsDetail[1]);
                    member.setName(goodsDetail[1].split("@")[0]);
                    member.setPassword(BCryptUtil.encrypt("1234"));
                    member.setTraded( (int)(Math.random() * 100) + 1);
                    member.setGrade(Math.round(Math.random() * 50.0) / 10.0);
                    memberMapper.insertMemberInfo(member);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (goodsReader != null) {
                        goodsReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
