package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class GoodsInfoVO {

    // name : 상품이름
    private String name;

    // imageUrl : 상품 이미지 url
    private String imageUrl;

    // price : 상품 대여 가격
    private int price;

    // lenderEmail : 상품 등록자
    private String lenderEmail;

    // reviews : 리뷰 수
    private int reviews;

    // grade : 상품 평점
    private double grade;

}
