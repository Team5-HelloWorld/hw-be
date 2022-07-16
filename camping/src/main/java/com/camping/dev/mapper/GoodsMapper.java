package com.camping.dev.mapper;

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
                               @Param("reviews") int reviews,
                               @Param("imageUrl") String imageUrl);

    // 상품 아이디로 상품 정보 찾기
    public GoodsInfoVO getGoodsInfo(int id);

    // 상품 아이디로 상품 등록자 email 검색
    public String getLenderEmail(int id);

}
