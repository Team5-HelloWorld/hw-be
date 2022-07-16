package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Member {

    // 이메일
    private String email;

    // 비밀번호
    private String password;

    // 이름
    private String name;

    // 평점
    private int grade;

}
