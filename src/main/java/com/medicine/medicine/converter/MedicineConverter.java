package com.medicine.medicine.converter;

import com.medicine.medicine.dbo.MedicineDbo;
import com.medicine.medicine.dto.MedicineDto;
import org.springframework.beans.BeanUtils;

public class MedicineConverter implements DtoDboConverter<MedicineDto, MedicineDbo> {

    @Override
    public MedicineDto convertToDto(MedicineDbo dbo) {
        final MedicineDto medicineDto = new MedicineDto();
        BeanUtils.copyProperties(dbo, medicineDto);
        return medicineDto;
    }

    @Override
    public MedicineDbo convertToDbo(MedicineDto dto) {
        final MedicineDbo medicineDbo = new MedicineDbo();
        BeanUtils.copyProperties(dto, medicineDbo);
        return medicineDbo;
    }
}
