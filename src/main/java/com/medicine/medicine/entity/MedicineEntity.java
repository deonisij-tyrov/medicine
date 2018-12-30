package com.medicine.medicine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "medicine")
@EqualsAndHashCode
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "medicine")
    private String medicine;

    @NotNull
    @Column(name = "price")
    private int price;

    @ManyToMany(mappedBy = "medicineEntitySet")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<OrderEntity> orderEntitySet = new HashSet<>();

}
