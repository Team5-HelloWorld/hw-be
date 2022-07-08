package com.camping.dev.service;

import com.camping.dev.mapper.MemberMapper;
import com.camping.dev.model.vo.LoginCompareVO;
import com.camping.dev.model.vo.LoginInfoVO;
import com.camping.dev.model.vo.LoginResultVO;
import com.camping.dev.util.BCryptUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

    private MemberMapper memberMapper;

    private final Logger logger = LoggerFactory.getLogger("LoginServiceImpl's log");

    public LoginResultVO memberLogin(LoginInfoVO loginInfoVO) {

        LoginResultVO loginResultVO = new LoginResultVO();

        try {

            LoginCompareVO loginCompareVO = memberMapper.loginByEmail(loginInfoVO.getEmail());
            if (BCryptUtil.isMatch(loginInfoVO.getPassword(), loginCompareVO.getPassword())) {
                loginResultVO.setStatus("login success");
            } else {
                loginResultVO.setStatus("wrong password");
            }

            BeanUtils.copyProperties(loginCompareVO, loginResultVO);

        } catch (NullPointerException e) {

            loginResultVO.setStatus("wrong Id");

        }

        return loginResultVO;

    }

}
