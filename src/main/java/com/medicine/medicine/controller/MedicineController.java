package com.medicine.medicine.controller;

import com.medicine.medicine.dto.MedicineDto;
import com.medicine.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createMedicine(@RequestBody final MedicineDto medicineDto) {
        medicineService.creatMedicine(medicineDto);
        return new ResponseEntity<>("Medicine created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/list")
    public List<MedicineDto> getAllMedicine() {
        return medicineService.getMedicineList();
    }

//    @GetMapping("/test")
//    public String getTest () {
//        return "test";
//    }
}
