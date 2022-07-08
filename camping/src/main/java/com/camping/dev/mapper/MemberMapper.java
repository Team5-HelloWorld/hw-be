package com.camping.dev.mapper;

import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.LoginCompareVO;

public interface MemberMapper {

    public void insertMemberInfo(Member member);

    public int searchByEmail(String email);

    public LoginCompareVO loginByEmail(String email);

}
