package com.example.testparagonsoftware.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUserDTO {

    private String email;
    private String name;
    private String phoneNumber;

}
