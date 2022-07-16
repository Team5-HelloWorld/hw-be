package com.camping.dev.mapper;

import com.camping.dev.model.vo.*;

import java.util.List;

public interface RentalMapper {

    // 상품 아이디로 리뷰 작성자 및 내용 검색
    public List<RentalPeriodVO> getRentPeriod(int id);

    // 대여 요청 처리
    public void insertRentalRequest(RentalRequestVO rentalRequestVO);

    // 임차인의 대여 정보 정리
    public List<RentInfoVO> getRentInfo(EmailRequestVO emailRequestVO);

    // 임대인의 정보 정리
    public List<LendInfoVO> getLendInfo(EmailRequestVO emailRequestVO);

}
