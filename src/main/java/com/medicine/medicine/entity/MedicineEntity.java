package com.medicine.medicine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "MEDICINE")
    private String medicine;

    @NotNull
    @Column(name = "PRICE")
    private int price;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "order_medicine",
            joinColumns = {@JoinColumn(name = "MEDICINE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID")}
    )
    @JsonIgnore
    private List<OrderEntity> orderEntityList;

}
