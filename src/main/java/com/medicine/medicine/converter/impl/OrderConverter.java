package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.dto.OrderDto;
import com.medicine.medicine.entity.OrderEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter implements DtoDboConverter<OrderDto, OrderEntity> {
    @Override
    public OrderDto convertToDto(OrderEntity entity) {
        final OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(entity, orderDto);
        return orderDto;
    }

    @Override
    public OrderEntity convertToDbo(OrderDto dto) {
        final OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(dto, orderEntity);
        return orderEntity;
    }
}
