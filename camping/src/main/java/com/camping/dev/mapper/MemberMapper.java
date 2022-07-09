package com.camping.dev.mapper;

import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.LoginCompareVO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    public void insertMemberInfo(Member member);

    public int searchByEmail(String email);

    public LoginCompareVO loginByEmail(String email);

    public String searchHashedByEmail(String email);

    public void modifyPassword(@Param("email") String email,
                               @Param("password") String password);

}
