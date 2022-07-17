package com.camping.dev.mapper;

import com.camping.dev.model.vo.ReviewVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewMapper {

    // 서버 재실행 시 리뷰테이블에 데이터가 있는지 확인
    public int getCount();

    // 초기 리뷰 데이터 적재
    public void insertInitData(@Param("prdId") String prdId,
                               @Param("userId") String userId,
                               @Param("grade") int grade,
                               @Param("review") String review);

    // 리뷰 테이블에 상품 테이블의 id update
    public void updateId();

    // 상품 아이디로 리뷰 작성자 및 내용 검색
    public List<ReviewVO> getReview(int id);

    // 리뷰 작성
    public void insertReview(@Param("id") int id,
                             @Param("email") String email,
                             @Param("grade") int grade,
                             @Param("review") String review);

}
