package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class MedicineDto {
    private long id;
    private String medicine;
    private int price;
//    private Set<OrderDto> orderDtoSet = new HashSet<>();
}
