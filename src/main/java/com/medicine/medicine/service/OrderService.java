package com.medicine.medicine.service;

import com.medicine.medicine.converter.impl.OrderConverter;
import com.medicine.medicine.dto.OrderDto;
import com.medicine.medicine.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderConverter orderConverter;

    @Autowired
    public OrderService(final OrderRepository orderRepository, final OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

    public OrderDto getOrder(Long id) {
        return orderConverter.convertToDto(orderRepository.getOne(id));
    }
}
