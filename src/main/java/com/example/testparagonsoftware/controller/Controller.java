package com.example.testparagonsoftware.controller;

import com.example.testparagonsoftware.dto.RequestDTO;
import com.example.testparagonsoftware.dto.ResponseDTO;
import com.example.testparagonsoftware.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class Controller {
    private final UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseDTO create(@RequestBody RequestDTO createUserDTO) {
        return userService.saveUser(createUserDTO);
    }

    @DeleteMapping("/user/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }

    @GetMapping("/user/{id}")
    public ResponseDTO getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
