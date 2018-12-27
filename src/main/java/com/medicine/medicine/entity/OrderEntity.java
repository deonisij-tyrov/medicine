package com.medicine.medicine.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_medicine",
            joinColumns = {@JoinColumn(name = "ID_MEDICINE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_ORDER")}
    )
    private List<MedicineEntity> medicineEntityList;

}
