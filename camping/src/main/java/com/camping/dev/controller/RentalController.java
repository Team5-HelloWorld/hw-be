package com.camping.dev.controller;

import com.camping.dev.model.vo.RentalAcceptResponseVO;
import com.camping.dev.model.vo.RentalAcceptVO;
import com.camping.dev.model.vo.RentalRequestResponseVO;
import com.camping.dev.model.vo.RentalRequestVO;
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
    public RentalRequestResponseVO sendRentalRequest(@RequestBody RentalRequestVO rentalRequestVO) {

        RentalRequestResponseVO resultVO = rentalService.sendRentalRequest(rentalRequestVO);
        return resultVO;

    }

    // 대여 수락
    @PostMapping("/accept")
    public RentalAcceptResponseVO sendRentalAccept(@RequestBody RentalAcceptVO rentalAcceptVO) {

        RentalAcceptResponseVO resultVO = rentalService.sendRentalAccept(rentalAcceptVO);
        return resultVO;

    }

}
