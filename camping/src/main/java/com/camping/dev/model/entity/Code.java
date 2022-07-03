package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Code {

    // 공통코드
    private Long codeNumber;

    // 코드 종류 구분
    private String codeDepth;

    // 코드 이름
    private String codeName;

}
