package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class RentalRequestVO {

    // 상품 아이디
    private int id;

    // 상품 등록자 이메일
    private String lenderEmail;

    // 대여자 이메일
    private String email;

    // 대여 시작 날짜
    private String rentalStartDate;

    // 대여 종료 날짜
    private String rentalEndDate;

}
