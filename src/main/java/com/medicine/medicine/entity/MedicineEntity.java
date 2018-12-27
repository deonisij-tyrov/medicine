package com.medicine.medicine.entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "medicine")
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String medicine;

    @NotNull
    private int price;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_medicine",
            joinColumns = {@JoinColumn(name = "ID_ORDER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_MEDICINE")}
    )
    private List<MedicineEntity> orderEntityList;

}
