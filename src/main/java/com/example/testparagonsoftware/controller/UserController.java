package com.example.testparagonsoftware.controller;

import com.example.testparagonsoftware.dto.RequestUserDTO;
import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.exceptions.FieldValidationException;
import com.example.testparagonsoftware.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Integer createUser(@Valid @RequestBody RequestUserDTO requestUserDTO, BindingResult result) {
        if (result.hasErrors()){
            throw new FieldValidationException(result);
        }
        return userService.saveUser(requestUserDTO);
    }

    @GetMapping("/user/{id}")
    public ResponseUserDTO getById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
}


