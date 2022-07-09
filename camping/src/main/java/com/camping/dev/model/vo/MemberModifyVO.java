package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class MemberModifyVO {

    private String email;

    private String currentPassword;

    private String newPassword;

}
