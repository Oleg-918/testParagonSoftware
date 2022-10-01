package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.RequestDTO;
import com.example.testparagonsoftware.dto.ResponseDTO;
import com.example.testparagonsoftware.mapper.UserMapper;
import com.example.testparagonsoftware.model.User;
import com.example.testparagonsoftware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl{
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public ResponseDTO getUserById(Integer id) {
        return userMapper.toResponseDTO(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found")));
    }

    public ResponseDTO saveUser(RequestDTO requestDTO) {
        User user = userMapper.toModel(requestDTO);
        userRepository.save(user);
        ResponseDTO responseDTO = userMapper.toResponseDTO(user);
        return responseDTO;
    }
    public void removeUserById(Integer id) {
        userRepository.deleteById(id);
    }
}