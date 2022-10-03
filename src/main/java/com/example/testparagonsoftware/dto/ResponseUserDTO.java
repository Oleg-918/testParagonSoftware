package com.example.testparagonsoftware.dto;

import com.example.testparagonsoftware.model.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseUserDTO {

    private String email;
    private String name;
    private String phoneNumber;
    private UserStatusEnum status;
}
