package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class RentalReturnVO {

    // 상품 아이디
    private int id;

    // 작성자 이메일
    private String email;

    // 리뷰내용
    private String review;

    // 평점
    private int grade;

}
