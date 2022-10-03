package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.exceptions.UserNotFoundException;
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

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getUserById() {
        Integer id = 1;
        ResponseUserDTO expected = ResponseUserDTO.builder().email("a").name("a").phoneNumber("1").status(UserStatusEnum.ONLINE).build();
        User user = User.builder().email("a").name("a").phoneNumber("1").status(UserStatusEnum.ONLINE).id(id).build();
        when(userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(id))).thenReturn(user);
        ResponseUserDTO actual = userService.getUserById(id);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void saveUser() {
    }

    @Test
    void removeUserById() {
    }
}