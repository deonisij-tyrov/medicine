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
    public MedicineDto convertToDto(MedicineEntity dbo) {
        final MedicineDto medicineDto = new MedicineDto();
        BeanUtils.copyProperties(dbo, medicineDto);
        return medicineDto;
    }

    @Override
    public MedicineEntity convertToDbo(MedicineDto dto) {
        final MedicineEntity medicineEntity = new MedicineEntity();
        BeanUtils.copyProperties(dto, medicineEntity);
        return medicineEntity;
    }

    public List<MedicineDto> convertToDto(final List<MedicineEntity> dboList) {
        final List<MedicineDto> result = new ArrayList<>();
        dboList.forEach((dbo) -> { result.add(convertToDto(dbo)); });
        return result;
    }

    public List<MedicineEntity> convertToDbo(final List<MedicineDto> dtoList) {
        final List<MedicineEntity> result = new ArrayList<>();
        dtoList.forEach((dto) -> { result.add(convertToDbo(dto)); });
        return result;
    }
}
