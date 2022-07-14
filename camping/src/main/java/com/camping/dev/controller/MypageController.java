package com.camping.dev.controller;

import com.camping.dev.model.vo.RentInfoRequestVO;
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
    public List<RentInfoVO> getRentInfo(@RequestBody RentInfoRequestVO requestVO) {

        List<RentInfoVO> resultVO = mypageService.getRentInfo(requestVO);
        return resultVO;

    }

}
