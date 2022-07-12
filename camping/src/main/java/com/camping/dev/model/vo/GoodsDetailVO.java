package com.camping.dev.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDetailVO {

    // name : 상품이름
    private String name;

    // imageUrl : 상품 이미지 url
    private String imageUrl;

    // price : 상품 대여 가격
    private int price;

    // reviews : 리뷰 수
    private int reviews;

    // goodsInfo : 상품 상세정보
    private String goodsInfo;

    // rentPeriod : 상품의 대여기간 정보
    private List<RentalPeriodVO> rentPeriod;

    // review : 리뷰내용 (이메일, 리뷰내용, 리뷰평점)
    private List<ReviewVO> review;

}
