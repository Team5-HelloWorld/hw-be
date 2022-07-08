package com.camping.dev.controller;

import com.camping.dev.model.vo.AuthInfoVO;
import com.camping.dev.model.vo.LoginInfoVO;
import com.camping.dev.model.vo.LoginResultVO;
import com.camping.dev.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    private final Logger logger = LoggerFactory.getLogger("LoginController's Log");

    @PostMapping
    public LoginResultVO memberLogin(@RequestBody LoginInfoVO loginInfoVO, HttpSession session) {

        LoginResultVO resultVO = loginService.memberLogin(loginInfoVO);

        if("8000".equals(resultVO.getStatus())) {

            AuthInfoVO authInfo = new AuthInfoVO();
            authInfo.setEmail(resultVO.getEmail());
            authInfo.setName(resultVO.getName());

            session.setAttribute("authinfo", authInfo);

        }

        return resultVO;

    }

}
