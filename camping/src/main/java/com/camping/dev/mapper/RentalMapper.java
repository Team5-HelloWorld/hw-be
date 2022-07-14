package com.camping.dev.mapper;

import com.camping.dev.model.vo.RentInfoRequestVO;
import com.camping.dev.model.vo.RentInfoVO;
import com.camping.dev.model.vo.RentalPeriodVO;
import com.camping.dev.model.vo.RentalRequestVO;

import java.util.List;

public interface RentalMapper {

    // 상품 아이디로 리뷰 작성자 및 내용 검색
    public List<RentalPeriodVO> getRentPeriod(int id);

    // 대여 요청 처리
    public void insertRentalRequest(RentalRequestVO rentalRequestVO);

    // 임차인의 대여 정보 정리
    public List<RentInfoVO> getRentInfo(RentInfoRequestVO rentInfoRequestVO);

}
