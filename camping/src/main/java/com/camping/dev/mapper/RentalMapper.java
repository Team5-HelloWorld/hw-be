package com.camping.dev.mapper;

import com.camping.dev.model.vo.RentalPeriodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentalMapper {

    // 상품 아이디로 리뷰 작성자 및 내용 검색
    public List<RentalPeriodVO> getRentPeriod(int id);

    public void insertRentalRequest(@Param("prdId") int prdId,
                                    @Param("borrowerEmail") String borrowerEmail,
                                    @Param("rentalStartDate") String rentalStartDate,
                                    @Param("rentalEndDate") String rentalEndDate,
                                    @Param("rentStatus") String rentStatus);

}
