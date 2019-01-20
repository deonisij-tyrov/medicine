package com.medicine.medicine.controller;

import com.medicine.medicine.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/sign-up")
    public ResponseEntity<Response<UserDto>> signUp(@RequestBody @Valid LoginDto loginDto) {
        return loginService.signUp(loginDto);
    }
}
