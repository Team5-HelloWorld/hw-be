package com.camping.dev.controller;

import com.camping.dev.model.vo.*;
import com.camping.dev.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    private final Logger logger = LoggerFactory.getLogger("RentalController's Log");

    // 대여 요청 보내기
    @PostMapping("/request")
    public RentalResponseVO sendRentalRequest(@RequestBody RentalRequestVO rentalRequestVO) {

        RentalResponseVO resultVO = rentalService.sendRentalRequest(rentalRequestVO);
        return resultVO;

    }

    // 대여 수락
    @PostMapping("/accept")
    public RentalResponseVO sendRentalAccept(@RequestBody RentalAcceptVO rentalAcceptVO) {

        RentalResponseVO resultVO = rentalService.sendRentalAccept(rentalAcceptVO);
        return resultVO;

    }

    // 대여 거절
    @PostMapping("/reject")
    public RentalResponseVO sendRentalReject(@RequestBody RentalRejectVO rentalRejectVO) {

        RentalResponseVO resultVO = rentalService.sendRentalReject(rentalRejectVO);
        return resultVO;

    }

    // 대여 반환 & 리뷰 작성
    @PostMapping("/return")
    public RentalResponseVO sendRentalReturn(@RequestBody RentalReturnVO rentalReturnVO) {

        RentalResponseVO resultVO = rentalService.sendRentalReturn(rentalReturnVO);
        return resultVO;

    }

}
