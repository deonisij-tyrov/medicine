package com.medicine.medicine.controller;

import com.medicine.medicine.dto.MedicineDto;
import com.medicine.medicine.dto.OrderDto;
import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/create")
    public OrderDto getAllMedicine(@RequestParam long id) {

        if (id == 0) {
            return new OrderDto();
        } else {
            return orderService.getOrder(id);
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity getAllMedicine() {
        final List<OrderDto> allOrders = orderService.getAllOrders();
        if (allOrders != null) {
            return new ResponseEntity<>(allOrders, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
