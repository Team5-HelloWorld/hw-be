package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Rental {

    // 대여요청 ID
    private Long id;

    // 상품 ID
    private Long productId;

    // 임대인 email
    private String lenderEmail;

    // 임차인 email
    private String borrowerEmail;

    // 대여 시작 날짜
    private String rentalStartDate;

    // 대여 종료 날짜
    private String rentalEndDate;

    // 요청메세지
    private String message;

    // 대여상태
    private String rentStatus;

}
