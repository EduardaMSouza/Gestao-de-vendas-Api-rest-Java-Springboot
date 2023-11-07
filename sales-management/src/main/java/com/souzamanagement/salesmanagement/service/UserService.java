package com.souzamanagement.salesmanagement.service;

import com.souzamanagement.salesmanagement.dto.user.UserRequestDto;
import com.souzamanagement.salesmanagement.dto.user.UserResponseDto;
import com.souzamanagement.salesmanagement.entity.UserModel;
import com.souzamanagement.salesmanagement.exception.AlreadyExistsException;
import com.souzamanagement.salesmanagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDto postUser(UserRequestDto dto) {
        var existsByEmail = userRepository.existsByEmail(dto.getEmail());
        if(existsByEmail) {
            throw new AlreadyExistsException("User already exists");
        }
        var user = modelMapper.map(dto, UserModel.class);
        var savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public List<UserResponseDto> getUsers() {
        var users = userRepository.findAll();
        List<UserResponseDto> usersDto = users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
        return usersDto;
    }
}
