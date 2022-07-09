package com.camping.dev.service;

import com.camping.dev.model.vo.MemberModifyResultVO;
import com.camping.dev.model.vo.MemberModifyVO;
import com.camping.dev.model.vo.MemberRegisterVO;

public interface MemberService {

    public MemberRegisterVO registerMember(MemberRegisterVO memberRegisterVO);

    public MemberModifyResultVO modifyMember(MemberModifyVO memberModifyVO);

}
