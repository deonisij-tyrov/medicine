package com.medicine.medicine.controller;

import com.medicine.medicine.dto.MedicineDto;
import com.medicine.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineController {
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/create")
    public String createMedicine(@RequestBody final MedicineDto medicineDto) {
        medicineService.creatMedicine(medicineDto);
        return "Created";
    }

    @GetMapping(value = "/list")
    public List<MedicineDto> getAllMedicine() {
        return medicineService.getMedicineList();
    }

    @GetMapping("/test")
    public String getTest () {
        return "test";
    }
}
