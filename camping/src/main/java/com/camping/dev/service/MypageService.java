package com.camping.dev.service;

import com.camping.dev.model.vo.RentInfoRequestVO;
import com.camping.dev.model.vo.RentInfoVO;

import java.util.List;

public interface MypageService {

    public List<RentInfoVO> getRentInfo(RentInfoRequestVO requestVO);

}
