package com.camping.dev.mapper;

import com.camping.dev.model.vo.CalculateGoodsGradeVO;
import com.camping.dev.model.vo.GoodsInfoVO;
import com.camping.dev.model.vo.GoodsSampleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    // 메인 페이지에 보여줄 상품 데이터 로딩
    public List<GoodsSampleVO> getSampleList();

    // 서버 재실행 시 상품테이블에 데이터가 있는지 확인
    public int getCount();

    // 초기 상품 데이터 적재
    public void insertInitData(@Param("prdId") String prdId,
                               @Param("email") String email,
                               @Param("category") String category,
                               @Param("name") String name,
                               @Param("price") int price,
                               @Param("imageUrl") String imageUrl);

    // 리뷰 테이블에서 추출한 상품별 리뷰 갯수 및 평균 평점을 상품 테이블에 적재
    public void updateReviewAndGrade(@Param("prdIdTmp") String prdIdTmp,
                                     @Param("cntReview") int cntReview,
                                     @Param("avgGrade") double avgGrade);

    // 상품 아이디로 상품 정보 찾기
    public GoodsInfoVO getGoodsInfo(int id);

    // 상품 아이디로 상품 등록자 email 검색
    public String getLenderEmail(int id);

    // 상품 기존 리뷰수와 평점 검색
    public CalculateGoodsGradeVO selectReviewsAndGrade(int id);

    // 상품 리뷰 수 및  평점 갱신
    public void updateNewReviewAndNewGrade(@Param("id") int id,
                                           @Param("reviews") int reviews,
                                           @Param("grade") double grade);

}
