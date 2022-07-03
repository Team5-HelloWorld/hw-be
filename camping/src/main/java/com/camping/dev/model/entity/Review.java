package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Review {

    // 리뷰 ID
    private Long id;

    // 상품 ID
    private Long productId;

    // 이메일
    private String email;

    // 리뷰 평점
    private Long grade;

    // 긍부정 판별
    private Boolean result_yn;

    // 리뷰내용
    private String review;

    // 리뷰삭제여부
    private Boolean deleteYN;

}
