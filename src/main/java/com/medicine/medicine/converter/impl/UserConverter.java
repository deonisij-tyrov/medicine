package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserConverter implements DtoDboConverter<UserDto, UserEntity> {
    private OrderConverter orderConverter;
    @Override
    public UserDto convertToDto(UserEntity entity) {
        final UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto);
        userDto.setOrderEntitySet(orderConverter.convertSetToDto(entity.getOrderEntitySet()));
        return userDto;
    }

    @Override
    public UserEntity convertToDbo(UserDto dto) {
        final UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(dto, userEntity);
        userEntity.setOrderEntitySet(orderConverter.convertSetToDbo(dto.getOrderEntitySet()));
        return userEntity;
    }
}
