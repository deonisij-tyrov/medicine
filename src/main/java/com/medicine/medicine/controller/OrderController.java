package com.medicine.medicine.controller;

import com.medicine.medicine.dto.OrderDto;
import com.medicine.medicine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public OrderDto getAllMedicine(@RequestParam long id) {

        if (id == 0) {
            return new OrderDto();
        } else {
            return orderService.getOrder(id);
        }
    }
}
