package com.camping.dev.mapper;

import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.CalculateUserGradeVO;
import com.camping.dev.model.vo.EmailRequestVO;
import com.camping.dev.model.vo.LoginCompareVO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    public void insertMemberInfo(Member member);

    public int searchByEmail(String email);

    public LoginCompareVO loginByEmail(String email);

    public String searchHashedByEmail(String email);

    public void modifyPassword(@Param("email") String email,
                               @Param("password") String password);

    // 회원의 기존 거래 건수와 평점 검색
    public CalculateUserGradeVO selectTradedAndGrade(String email);

    // 거래 건수 및 평점 갱신
    public void updateTradedAndGrade(@Param("email") String email,
                                     @Param("traded") int traded,
                                     @Param("grade") double grade);

    // 유저 평점 검색
    public double searchGrade(EmailRequestVO requestVO);

}
