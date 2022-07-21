package com.camping.dev.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class MypageOverviewVO {

    // 유저 평점
    private double grade;
    
    // 총 임차 건수
    private int rentTotal;

    // 임차 요청중 건수 (rentStatus = "01")
    private int rentRequestTotal;

    // 임차 중 건수 (rentStatus = "02")
    private int rentingTotal;

    // 임차 완료된 갯수 (rentStatus = "03")
    private int rentCompleteTotal;

    // 임차 총 금액
    private String rentPriceSum;



    // 총 임대 건수
    private int lendTotal;

    // 임대 요청중 건수 (rentStatus = "01")
    private int lendRequestTotal;

    // 임대 중 건수 (rentStatus = "02")
    private int lendingTotal;

    // 임대 완료된 건수 (rentStatus = "03")
    private int lendCompleteTotal;

    // 임대 총 금액
    private String lendPriceSum;



    // 모든 임차 내역 히스토리
    private List<MyRentInfoVO> rentInfo;

    // 모든 임대 내역 히스토리
    private List<MyLendInfoVO> lendInfo;

}
