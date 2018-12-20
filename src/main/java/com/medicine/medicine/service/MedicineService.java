package com.medicine.medicine.service;

import com.medicine.medicine.converter.MedicineConverter;
import com.medicine.medicine.dao.MedicineRepository;
import com.medicine.medicine.dto.MedicineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final MedicineConverter medicineConverter;

    @Autowired
    public MedicineService (final MedicineRepository medicineRepository, final MedicineConverter medicineConverter) {
        this.medicineConverter = medicineConverter;
        this.medicineRepository = medicineRepository;
    }

    public void creatMedicine(final MedicineDto medicineDto) {
        medicineRepository.save(medicineConverter.convertToDbo(medicineDto));
    }

    public List<MedicineDto> getMedicineList() {
        return medicineRepository.findAll().stream()
                .map(medicineConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
