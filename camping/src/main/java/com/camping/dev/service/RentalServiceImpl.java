package com.camping.dev.service;

import com.camping.dev.mapper.GoodsMapper;
import com.camping.dev.mapper.RentalMapper;
import com.camping.dev.model.vo.*;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private RentalMapper rentalMapper;
    private GoodsMapper goodsMapper;
    private final Logger logger = LoggerFactory.getLogger("RentalServiceImpl's log");

    // 대여 요청
    public RentalResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            if(rentalMapper.countingRentInfoByEmail(rentalRequestVO.getId(),
                                                    rentalRequestVO.getEmail()) == 0) {

                rentalRequestVO.setLenderEmail(goodsMapper.getLenderEmail(rentalRequestVO.getId()));
                rentalMapper.insertRentalRequest(rentalRequestVO);
                resultVO.setStatus("6000");

            } else {

                resultVO.setStatus("6002");    // 6002 : 중복 대여 요청

            }



        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }


    // 대여 수락
    public RentalResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.updateRental(rentalAcceptVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }


    // 대여 거절
    public RentalResponseVO sendRentalReject(RentalRejectVO rentalRejectVO) {

        RentalResponseVO resultVO = new RentalResponseVO();

        try {

            rentalMapper.rejectRental(rentalRejectVO);
            resultVO.setStatus("6000");

        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVO.setStatus("6001");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;

    }

}
