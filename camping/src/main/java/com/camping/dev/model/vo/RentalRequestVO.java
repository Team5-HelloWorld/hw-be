package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class RentalRequestVO {

    private int id;

    private String email;

    private String rentalStartDate;

    private String rentalEndDate;

}
