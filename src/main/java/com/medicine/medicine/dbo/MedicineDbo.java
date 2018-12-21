package com.medicine.medicine.dbo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "MEDICINE")
public class MedicineDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String medicine;

    @NotNull
    private int price;

}
