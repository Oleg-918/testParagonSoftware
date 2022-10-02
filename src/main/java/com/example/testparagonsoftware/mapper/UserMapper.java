package com.example.testparagonsoftware.mapper;


import com.example.testparagonsoftware.dto.RequestUserDTO;
import com.example.testparagonsoftware.dto.ResponseUserDTO;
import com.example.testparagonsoftware.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    ResponseUserDTO toResponseDTO(User user);
    User toModel(RequestUserDTO createUserDTO);
}
