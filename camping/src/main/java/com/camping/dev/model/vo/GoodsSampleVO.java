package com.camping.dev.model.vo;

import lombok.Data;

/**
 * Main Page 에 노출시키기 위해 프론트에 반환하는 샘플 상품 정보
 */

@Data
public class GoodsSampleVO {

    // id : 상품번호
    private Long id;

    // category : 상품분류 카테고리
    private String category;

    // name : 상품이름
    private String name;

    // price : 상품 대여 가격
    private int price;

    // reviews : 리뷰 수
    private int reviews;

    // imageUrl : 상품 이미지 url
    private String imageUrl;

}
