package com.camping.dev.service;

import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.model.vo.EmailRequestVO;
import com.camping.dev.model.vo.LendInfoVO;
import com.camping.dev.model.vo.RentInfoVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
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
    public List<RentInfoVO> getRentInfo(EmailRequestVO requestVO) {

        List<RentInfoVO> resultVO = null;

        try {
            resultVO = rentalMapper.getRentInfo(requestVO);
        } catch(SqlSessionException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }

    @Override
    public List<LendInfoVO> getLendInfo(EmailRequestVO requestVO) {

        List<LendInfoVO> resultVO = null;

        try {
            resultVO = rentalMapper.getLendInfo(requestVO);
        } catch(SqlSessionException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }

}
