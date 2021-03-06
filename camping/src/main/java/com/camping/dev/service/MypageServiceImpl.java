package com.camping.dev.service;

import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.model.vo.*;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class MypageServiceImpl implements MypageService{

    private MemberMapper memberMapper;
    private RentalMapper rentalMapper;
    private final Logger logger = LoggerFactory.getLogger("MypageServiceImpl's log");

    @Override
    public List<RentInfoVO> getRentInfo(EmailRequestVO requestVO) {

        List<RentInfoVO> resultVO = null;

        try {
            resultVO = rentalMapper.getRentInfo(requestVO);
        } catch(SqlSessionException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }

    @Override
    public List<LendInfoVO> getLendInfo(EmailRequestVO requestVO) {

        List<LendInfoVO> resultVO = null;

        try {
            resultVO = rentalMapper.getLendInfo(requestVO);
        } catch(SqlSessionException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }

    @Override
    public MypageOverviewVO getOverview(EmailRequestVO requestVO) {

        MypageOverviewVO resultVO = new MypageOverviewVO();
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");   // 화폐 단위 구분을 위한 패턴

        /**
         *  대여 요청 코드
         *  "01" : 대여 요청 중
         *  "02" : 현재 대여중 (임대인이 수락)
         *  "03" : 반환 완료 (기간 다됐거나 임차인 쪽에서 반환)
         */

        try {

            // 임차 총 건수 확인
            int rentTotal = rentalMapper.getMyRentTotal(requestVO);

            // 임대 총 건수 확인
            int lendTotal = rentalMapper.getMyLendTotal(requestVO);

            // 임차 내역 (빌려주고 있는 상품들 정보) 검색 및 가격 총합 산출
            if(rentTotal != 0) {

                List<MyRentInfoVO> rentInfos = rentalMapper.getMyRentInfo(requestVO);
                resultVO.setRentInfo(rentInfos);

                int rentRequestTotal = 0;
                int rentingTotal = 0;
                int rentCompleteTotal = 0;
                int rentPriceSumTmp = 0;
                for(MyRentInfoVO rentInfo : rentInfos) {
                    if("01".equals(rentInfo.getRentCodeNumber())) {
                        rentRequestTotal++;
                    } else if("02".equals(rentInfo.getRentCodeNumber())) {
                        rentingTotal++;
                        rentPriceSumTmp += (rentInfo.getPrice());
                    } else if("03".equals(rentInfo.getRentCodeNumber())) {
                        rentCompleteTotal++;
                        rentPriceSumTmp += (rentInfo.getPrice());
                    }

                }
                String rentPriceSum = formatter.format(rentPriceSumTmp);
                resultVO.setRentTotal(rentTotal);
                resultVO.setRentRequestTotal(rentRequestTotal);
                resultVO.setRentingTotal(rentingTotal);
                resultVO.setRentCompleteTotal(rentCompleteTotal);
                resultVO.setRentPriceSum(rentPriceSum);

            }

            // 임대 내역 검색 (빌리고 있는 상품들 정보) 검색 및 가격 총합 산출
            if(lendTotal != 0) {

                List<MyLendInfoVO> lendInfos = rentalMapper.getMyLendInfo(requestVO);
                resultVO.setLendInfo(lendInfos);

                int lendingTotal = 0;
                int lendRequestTotal = 0;
                int lendCompleteTotal = 0;
                int lendPriceSumTmp = 0;
                for(MyLendInfoVO lendInfo : lendInfos) {
                    if("01".equals(lendInfo.getRentCodeNumber())) {
                        lendRequestTotal++;
                    } else if("02".equals(lendInfo.getRentCodeNumber())) {
                        lendingTotal++;
                        lendPriceSumTmp += (lendInfo.getPrice());
                    } else if("03".equals(lendInfo.getRentCodeNumber())) {
                        lendCompleteTotal++;
                        lendPriceSumTmp += (lendInfo.getPrice());
                    }

                }
                String lendPriceSum = formatter.format(lendPriceSumTmp);
                resultVO.setLendTotal(lendTotal);
                resultVO.setLendRequestTotal(lendRequestTotal);
                resultVO.setLendingTotal(lendingTotal);
                resultVO.setLendCompleteTotal(lendCompleteTotal);
                resultVO.setLendPriceSum(lendPriceSum);

            }

            // 유저 평점 검색
            resultVO.setGrade(memberMapper.searchGrade(requestVO));

        } catch(SqlSessionException e) {
            e.printStackTrace();
        } catch(Exception e) {

        }

        return resultVO;
    }

}
