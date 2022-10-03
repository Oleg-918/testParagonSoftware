package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.ResponseUserDTO;
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
        ResponseUserDTO expected = ResponseUserDTO.builder().email("oleg@yandex.ru").name("Oleg").phoneNumber("89876027415").status(UserStatusEnum.ONLINE).build();
        User user = User.builder().email("oleg@yandex.ru").name("Oleg").phoneNumber("89876027415").status(UserStatusEnum.ONLINE).id(id).build();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
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