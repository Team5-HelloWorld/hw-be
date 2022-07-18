package com.camping.dev.controller;

import com.camping.dev.model.vo.LendInfoVO;
import com.camping.dev.model.vo.EmailRequestVO;
import com.camping.dev.model.vo.MypageOverviewVO;
import com.camping.dev.model.vo.RentInfoVO;
import com.camping.dev.service.MypageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageService mypageService;

    private final Logger logger = LoggerFactory.getLogger("MypageController's Log");

    @PostMapping("/rentinfo")
    public List<RentInfoVO> getRentInfo(@RequestBody EmailRequestVO requestVO) {

        List<RentInfoVO> resultVO = mypageService.getRentInfo(requestVO);
        return resultVO;

    }

    @PostMapping("/lendinfo")
    public List<LendInfoVO> getLendInfo(@RequestBody EmailRequestVO requestVO) {

        List<LendInfoVO> resultVO = mypageService.getLendInfo(requestVO);
        return resultVO;

    }

    @PostMapping("/overview")
    public MypageOverviewVO getOverview(@RequestBody EmailRequestVO requestVO) {

        MypageOverviewVO resultVO = mypageService.getOverview(requestVO);
        return resultVO;

    }

}
