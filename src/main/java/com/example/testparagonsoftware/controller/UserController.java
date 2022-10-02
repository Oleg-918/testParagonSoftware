package com.example.testparagonsoftware.controller;

import com.example.testparagonsoftware.dto.RequestUserDTO;
import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Integer create(@RequestBody RequestUserDTO createUserDTO) {
        return userService.saveUser(createUserDTO);
    }

    @GetMapping("/user/{id}")
    public ResponseUserDTO getById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
}


