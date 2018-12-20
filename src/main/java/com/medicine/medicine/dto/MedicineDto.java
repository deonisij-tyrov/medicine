package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineDto {
    private long id;
    private String medicine;
    private int price;
}
