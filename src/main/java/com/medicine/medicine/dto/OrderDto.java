package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class OrderDto {
    private long id;
    private String order;
    private Set<MedicineDto> medicineDtoSet = new HashSet<>();
//    private UserDto user;
}
