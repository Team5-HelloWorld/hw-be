package com.camping.dev.service;

import com.camping.dev.model.vo.*;

public interface RentalService {

    public RentalResponseVO sendRentalRequest(RentalRequestVO rentalRequestVO);

    public RentalResponseVO sendRentalAccept(RentalAcceptVO rentalAcceptVO);

    public RentalResponseVO sendRentalReject(RentalRejectVO rentalRejectVO);

    public RentalResponseVO sendRentalReturn(RentalReturnVO rentalReturnVO);

}
