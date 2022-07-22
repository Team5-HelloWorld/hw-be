package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class MyRentInfoVO {

    // 아이디
    private int id;

    // 상품이름
    private String name;

    // 상품 이미지 url
    private String imageUrl;

    // 상품 대여 가격
    private int price;

    // 대여 시작 날짜
    private String rentalStartDate;

    // 대여 종료 날짜
    private String rentalEndDate;

    // 대여 상태
    private String rentStatus;

    // 대여 코드 넘버
    private String rentCodeNumber;

}
