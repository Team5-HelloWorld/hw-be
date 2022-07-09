package com.camping.dev.controller;

import com.camping.dev.model.vo.LoginInfoVO;
import com.camping.dev.model.vo.LoginResultVO;
import com.camping.dev.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    private final Logger logger = LoggerFactory.getLogger("LoginController's Log");

    @PostMapping
    public LoginResultVO memberLogin(@RequestBody LoginInfoVO loginInfoVO) {

        // session 은 react 에서 관리하고 있기 때문에 여기서 생성하지 않음.
        LoginResultVO resultVO = loginService.memberLogin(loginInfoVO);

        return resultVO;

    }

}
