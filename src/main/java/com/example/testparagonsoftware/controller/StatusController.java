package com.example.testparagonsoftware.controller;

import com.example.testparagonsoftware.dto.ResponseStatusDTO;
import com.example.testparagonsoftware.model.UserStatusEnum;
import com.example.testparagonsoftware.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @PutMapping("/user/{id}/status")
    public ResponseStatusDTO changeStatus(@PathVariable("id") Integer id, @RequestParam UserStatusEnum newUserStatus) {
        return statusService.setUserStatus(id, newUserStatus);
    }
}
