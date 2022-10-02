package com.example.testparagonsoftware.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseUserDTO {

    private String email;
    private String name;
    private String phoneNumber;
    private String status;
}
