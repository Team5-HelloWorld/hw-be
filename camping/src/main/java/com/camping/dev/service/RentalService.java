package com.camping.dev.service;

import com.camping.dev.model.vo.RentalAcceptVO;
import com.camping.dev.model.vo.RentalRejectVO;
import com.camping.dev.model.vo.RentalRequestVO;
import com.camping.dev.model.vo.RentalResponseVO;

public interface RentalService {

    public RentalResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO);

    public RentalResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO);

    public RentalResponseVO sendRentalReject(RentalRejectVO rentalRejectVO);

}
