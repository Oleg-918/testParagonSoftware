package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.RequestUserDTO;
import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.mapper.UserMapper;
import com.example.testparagonsoftware.model.User;
import com.example.testparagonsoftware.model.UserStatusEnum;
import com.example.testparagonsoftware.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;
    private final Integer id =1;

    @Test
    void getUserById() {
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        when(userRepository.findById(id)).thenReturn(Optional.of(responseUserDTO));

        responseUserDTO = userService.getUserById(id);
        Assert.assertNotNull(responseUserDTO);
    }

    @Test
    void saveUser() {
        RequestUserDTO requestUserDTO = new RequestUserDTO();
        Integer integer = userService.saveUser(requestUserDTO);
        Assert.assertNotNull(integer);
    }

    @Test
    void removeUserById() {
    }
}