package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.RequestUserDTO;
import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.exceptions.UserNotFoundException;
import com.example.testparagonsoftware.mapper.UserMapper;
import com.example.testparagonsoftware.model.User;
import com.example.testparagonsoftware.model.UserStatusEnum;
import com.example.testparagonsoftware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public ResponseUserDTO getUserById(Integer id) {
        return userMapper.toResponseDTO(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

//    Как разультат POST-запроса возвращаем уникальный ID
    public Integer saveUser(RequestUserDTO requestDTO) {
        User user = userMapper.toModel(requestDTO);
        user.setStatus(UserStatusEnum.NONE);
        userRepository.save(user);
        return user.getId();
    }

    public void removeUserById(Integer id){
        userRepository.deleteById(id);
    }

}