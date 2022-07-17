package com.camping.dev.service;

import com.camping.dev.model.vo.RentalAcceptResponseVO;
import com.camping.dev.model.vo.RentalAcceptVO;
import com.camping.dev.model.vo.RentalRequestResponseVO;
import com.camping.dev.model.vo.RentalRequestVO;

public interface RentalService {

    public RentalRequestResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO);

    public RentalAcceptResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO);

}
