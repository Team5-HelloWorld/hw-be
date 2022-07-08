package com.camping.dev.service;

import com.camping.dev.model.vo.LoginInfoVO;
import com.camping.dev.model.vo.LoginResultVO;

public interface LoginService {

    public LoginResultVO memberLogin(LoginInfoVO loginInfoVO);

}
