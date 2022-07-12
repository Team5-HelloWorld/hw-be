package com.camping.dev.service;

import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.model.vo.RentalRequestVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private RentalMapper rentalMapper;
    private final Logger logger = LoggerFactory.getLogger("RentalServiceImpl's log");

    public String sendRentalRequest(RentalRequestVO rentalRequestVO) {

        String status;

        try {
            rentalMapper.insertRentalRequest(rentalRequestVO.getId(),
                                             rentalRequestVO.getEmail(),
                                             rentalRequestVO.getRentalStartDate(),
                                             rentalRequestVO.getRentalEndDate(),
                                             "01");
            status = "6000";

        } catch (SqlSessionException e) {
            e.printStackTrace();
            status = "6001";
        }

        return status;

    }

}
