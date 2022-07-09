package com.camping.dev.controller;

import com.camping.dev.model.vo.MemberModifyResultVO;
import com.camping.dev.model.vo.MemberModifyVO;
import com.camping.dev.model.vo.MemberRegisterVO;
import com.camping.dev.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final Logger logger = LoggerFactory.getLogger("MemberController's Log");

    // 회원가입
    @PostMapping("/register")
    public MemberRegisterVO registerMember(@RequestBody MemberRegisterVO memberRegisterVO) {

        MemberRegisterVO resultVO = memberService.registerMember(memberRegisterVO);
        return resultVO;

    }

    // 비밀번호 수정
    @PutMapping
    public MemberModifyResultVO modifyMember(@RequestBody MemberModifyVO memberModifyVO) {

        MemberModifyResultVO resultVO = memberService.modifyMember(memberModifyVO);
        return resultVO;

    }

}
