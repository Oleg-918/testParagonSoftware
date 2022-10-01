package com.example.testparagonsoftware.mapper;


import com.example.testparagonsoftware.dto.RequestDTO;
import com.example.testparagonsoftware.dto.ResponseDTO;
import com.example.testparagonsoftware.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    ResponseDTO toResponseDTO(User user);
    User toModel(RequestDTO createUserDTO);

    RequestDTO toRequestDTO(User user);
}
