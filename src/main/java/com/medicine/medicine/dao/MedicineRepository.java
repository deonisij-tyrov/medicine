package com.medicine.medicine.dao;

import com.medicine.medicine.dbo.MedicineDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<MedicineDbo, Long> {
}
