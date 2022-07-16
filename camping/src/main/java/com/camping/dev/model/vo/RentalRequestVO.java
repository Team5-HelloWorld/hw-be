package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class RentalRequestVO {

    private int id;

    // 상품 등록자 이메일
    private String lenderEmail;

    // 대여자 이메일
    private String email;

    private String rentalStartDate;

    private String rentalEndDate;

}
