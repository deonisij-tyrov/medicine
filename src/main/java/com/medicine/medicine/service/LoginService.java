package com.medicine.medicine.service;

import com.medicine.medicine.converter.impl.UserConverter;
import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.entity.UserEntity;
import com.medicine.medicine.repository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;

@Data
public class LoginService {
    UserRepository userRepository;
    UserConverter userConverter;

    public ResponseEntity<Response<UserDto>> signUp(UserDto user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        if (userRepository.findByLogin(user.getLogin()) == null) {
//            UserEntity dbo = userRepository.save(userConverter.convertToDbo(user));
//            return ResponseEntity.ok(Response.success(userConverter.convertToDto(dbo)));
//        } else {
//            return new ResponseEntity(Response.error("A user with this name already exists"), HttpStatus.BAD_REQUEST);
//        }
    }
}
