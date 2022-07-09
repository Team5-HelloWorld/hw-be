package com.camping.dev.service;

import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.model.entity.Member;
import com.camping.dev.model.vo.MemberModifyResultVO;
import com.camping.dev.model.vo.MemberModifyVO;
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

    @Override
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

    @Override
    public MemberModifyResultVO modifyMember(MemberModifyVO memberModifyVO) {

        MemberModifyResultVO resultVO = new MemberModifyResultVO();

        try {

            String hashed = memberMapper.searchHashedByEmail(memberModifyVO.getEmail());
            if (BCryptUtil.isMatch(memberModifyVO.getCurrentPassword(), hashed)) {
                memberMapper.modifyPassword(memberModifyVO.getEmail(),
                                            BCryptUtil.encrypt(memberModifyVO.getNewPassword()));
                resultVO.setStatus("7000");    // modify success
                logger.info(resultVO.getStatus());
            } else {
                resultVO.setStatus("8001");    // wrong password
                logger.info(resultVO.getStatus());
            }

            BeanUtils.copyProperties(memberModifyVO, resultVO);

        } catch (NullPointerException e) {

            resultVO.setStatus("8002");   // wrong Id
            logger.info(resultVO.getStatus());

        }

        return resultVO;

    }

}
