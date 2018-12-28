package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserConverter implements DtoDboConverter<UserDto, UserEntity> {
    @Override
    public UserDto convertToDto(UserEntity entity) {
        final UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto);
        return userDto;
    }

    @Override
    public UserEntity convertToDbo(UserDto dto) {
        final UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(dto, userEntity);
        return userEntity;
    }
}
