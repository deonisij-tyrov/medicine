package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private long id;
    private List<MedicineDto> medicineDtoList;
}
