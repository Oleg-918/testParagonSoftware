package com.example.testparagonsoftware.dto;

import com.example.testparagonsoftware.model.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatusDTO {
    private Integer id;
    private UserStatusEnum newUserStatus;
    private UserStatusEnum oldUserStatus;
}
