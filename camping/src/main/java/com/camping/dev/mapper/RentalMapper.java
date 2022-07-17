package com.camping.dev.mapper;

import com.camping.dev.model.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentalMapper {

    // 상품 아이디로 리뷰 작성자 및 내용 검색
    public List<RentalPeriodVO> getRentPeriod(int id);

    // 이메일로 status 가 '01' 건이 있는 지 검색 (중복요청 방지)
    public int countingRentInfoByEmail(@Param("id") int id,
                                       @Param("email") String email);

    // 대여 요청 처리
    public void insertRentalRequest(RentalRequestVO rentalRequestVO);

    // 대여 수락
    public void acceptRental(RentalAcceptVO rentalAcceptVO);

    // 대여 거절
    public void rejectRental(RentalRejectVO rentalRejectVO);

    // 대여 반환
    public void returnRental(RentalReturnVO rentalReturnVO);

    // 대여 반환 전 임대인 이메일 검색
    public String selectLenderEmail(RentalReturnVO rentalReturnVO);

    // 임차인의 대여 정보 정리
    public List<RentInfoVO> getRentInfo(EmailRequestVO emailRequestVO);

    // 임대인의 정보 정리
    public List<LendInfoVO> getLendInfo(EmailRequestVO emailRequestVO);

}
