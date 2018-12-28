package com.medicine.medicine.service;

import com.medicine.medicine.converter.impl.UserConverter;
import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.entity.UserEntity;
import com.medicine.medicine.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserConverter userConverter;

    public void create(final UserDto userDto) {
        UserEntity userEntity = userConverter.convertToDbo(userDto);
        userRepository.save(userEntity);
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::convertToDto).collect(Collectors.toList());
    }
}
