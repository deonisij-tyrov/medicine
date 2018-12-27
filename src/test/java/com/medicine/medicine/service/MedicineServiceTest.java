package com.medicine.medicine.service;

import com.medicine.medicine.MockData;
import com.medicine.medicine.converter.impl.MedicineConverter;
import com.medicine.medicine.entity.MedicineEntity;
import com.medicine.medicine.dto.MedicineDto;
import com.medicine.medicine.repository.MedicineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MedicineServiceTest {
    @InjectMocks
    private MedicineService medicineService;

    @Mock
    private MedicineRepository medicineRepository;
    @Spy
    private MedicineConverter medicineConverter;

    @Test
    public void creatMedicine() {
        final MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicine("test");
        doReturn(medicineEntity).when(medicineRepository).save(any(MedicineEntity.class));

        medicineService.creatMedicine(new MedicineDto());

        verify(medicineRepository, times(1)).save(any(MedicineEntity.class));
    }

    @Test
    public void getMedicineList() {
        final List<MedicineEntity> medicineEntityList = new ArrayList<>();
        final MedicineEntity medicineEntity = MockData.medicineDbo();
        medicineEntityList.add(medicineEntity);
        medicineEntityList.add(medicineEntity);
        doReturn(medicineEntityList).when(medicineRepository).findAll();

        final List<MedicineDto> medicineDtoList = medicineService.getMedicineList();

        verify(medicineRepository, times(1)).findAll();
        assertEquals(medicineEntityList.size(), medicineDtoList.size());
        for (final MedicineDto medicineDto : medicineDtoList) {
            System.out.println(medicineDto.getMedicine() + " " + medicineEntity.getMedicine());
            assertEquals(medicineDto.getMedicine(), medicineEntity.getMedicine());
            assertEquals(medicineDto.getPrice(), medicineEntity.getPrice());
        }


    }
}