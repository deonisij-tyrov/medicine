package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.entity.MedicineEntity;
import com.medicine.medicine.dto.MedicineDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineConverter implements DtoDboConverter<MedicineDto, MedicineEntity> {

    @Override
    public MedicineDto convertToDto(MedicineEntity entity) {
        final MedicineDto medicineDto = new MedicineDto();
        BeanUtils.copyProperties(entity, medicineDto);
        return medicineDto;
    }

    @Override
    public MedicineEntity convertToDbo(MedicineDto dto) {
        final MedicineEntity medicineEntity = new MedicineEntity();
        BeanUtils.copyProperties(dto, medicineEntity);
        return medicineEntity;
    }
}
