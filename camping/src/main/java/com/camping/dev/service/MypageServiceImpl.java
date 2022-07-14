package com.camping.dev.service;

import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.model.vo.RentInfoRequestVO;
import com.camping.dev.model.vo.RentInfoVO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MypageServiceImpl implements MypageService{

    private RentalMapper rentalMapper;
    private final Logger logger = LoggerFactory.getLogger("MypageServiceImpl's log");

    @Override
    public List<RentInfoVO> getRentInfo(RentInfoRequestVO requestVO) {

        List<RentInfoVO> resultVO = rentalMapper.getRentInfo(requestVO);
        return resultVO;

    }

}
