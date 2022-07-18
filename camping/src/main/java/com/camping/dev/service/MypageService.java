package com.camping.dev.service;

import com.camping.dev.model.vo.EmailRequestVO;
import com.camping.dev.model.vo.LendInfoVO;
import com.camping.dev.model.vo.MypageOverviewVO;
import com.camping.dev.model.vo.RentInfoVO;

import java.util.List;

public interface MypageService {

    public List<RentInfoVO> getRentInfo(EmailRequestVO requestVO);

    public List<LendInfoVO> getLendInfo(EmailRequestVO requestVO);

    public MypageOverviewVO getOverview(EmailRequestVO requestVO);

}
