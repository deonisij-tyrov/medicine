package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.entity.MedicineEntity;
import com.medicine.medicine.dto.MedicineDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class MedicineConverter implements DtoDboConverter<MedicineDto, MedicineEntity> {
//    private OrderConverter orderConverter;

    @Override
    public MedicineDto convertToDto(MedicineEntity entity) {
        final MedicineDto medicineDto = new MedicineDto();
        BeanUtils.copyProperties(entity, medicineDto);
//        medicineDto
//                .setOrderDtoSet(orderConverter
//                        .convertSetToDto(entity
//                                .getOrderEntitySet()));
        return medicineDto;
    }

    @Override
    public MedicineEntity convertToDbo(MedicineDto dto) {
        final MedicineEntity medicineEntity = new MedicineEntity();
        BeanUtils.copyProperties(dto, medicineEntity);
//        medicineEntity.setOrderEntitySet(orderConverter.convertSetToDbo(dto.getOrderDtoSet()));
        return medicineEntity;
    }

    public Set<MedicineDto> convertSetToDto(final Set<MedicineEntity> entity) {
        if (entity != null) {
            final Set<MedicineDto> dtoSet = new HashSet<>();
            for (final MedicineEntity medicineEntity : entity) {
                final MedicineDto convertToDto = convertToDto(medicineEntity);
                dtoSet.add(convertToDto);
            }
            return dtoSet;
        } else {
            return null;
        }
    }

    public Set<MedicineEntity> convertSetToDbo(final Set<MedicineDto> dto) {
        if (dto != null) {
            final Set<MedicineEntity> entitySet = new HashSet<>();
            for (final MedicineDto medicineDto : dto) {
                final MedicineEntity convertToEntity = convertToDbo(medicineDto);
                entitySet.add(convertToEntity);
            }
            return entitySet;
        } else {
            return null;
        }
    }
}
