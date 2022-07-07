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

    // reviews : 리뷰 수
    private int reviews;

}
