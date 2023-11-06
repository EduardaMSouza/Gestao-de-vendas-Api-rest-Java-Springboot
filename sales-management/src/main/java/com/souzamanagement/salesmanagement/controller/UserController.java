package com.souzamanagement.salesmanagement.controller;

import com.souzamanagement.salesmanagement.dto.UserRequestDto;
import com.souzamanagement.salesmanagement.dto.UserResponseDto;
import com.souzamanagement.salesmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserResponseDto> postUser(@RequestBody UserRequestDto dto) {
        var user = userService.postUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        var users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
