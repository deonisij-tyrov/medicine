package com.medicine.medicine.repository;

import com.medicine.medicine.dbo.MedicineDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineDbo, Long> {
}
