package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineDto {
    private long id;
    private String medicine;
    private int price;

    public MedicineDto(long id, String medicine, int price) {
        this.id = id;
        this.medicine = medicine;
        this.price = price;
    }
}
