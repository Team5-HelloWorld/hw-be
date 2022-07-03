package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Goods {

    // 상품 ID
    private Long id;

    // 상품 이름
    private String name;

    // 상품 이미지 url
    private String imageUrl;

    // 상품 대여 가격
    private Long price;

    // 상품 조회수
    private Long view;

    // 상품 등록 일자
    private String registerDate;

    // 상품 수량
    private Long count;

    // 상품상태
    private Boolean rentYN;

}
