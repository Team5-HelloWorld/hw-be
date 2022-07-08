package com.camping.dev.service;

import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.MemberRegisterVO;
import com.camping.dev.util.BCryptUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;

    private final Logger logger = LoggerFactory.getLogger("MemberServiceImpl's log");

    public MemberRegisterVO registerMember(MemberRegisterVO memberRegisterVO) {

        String encrypted = BCryptUtil.encrypt(memberRegisterVO.getPassword());
        memberRegisterVO.setPassword(encrypted);

        logger.info(encrypted);

        Member member = new Member();
        BeanUtils.copyProperties(memberRegisterVO, member);

        if (memberMapper.searchByEmail(member.getEmail()) == 0) {
            memberMapper.insertMemberInfo(member);
            memberRegisterVO.setStatus("9000");
        } else
            memberRegisterVO.setStatus("9001");

        return memberRegisterVO;

    }

}
