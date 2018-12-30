package com.medicine.medicine.controller;

import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity getAllUsers() {
        final List<UserDto> allUser = userService.getAllUsers();
        if (allUser != null) {
            return new ResponseEntity<>(allUser, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody final UserDto userDto) {
        userService.create(userDto);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }
}
