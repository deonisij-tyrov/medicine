package com.medicine.medicine.converter.impl;

import com.medicine.medicine.converter.DtoDboConverter;
import com.medicine.medicine.entity.OrderEntity;
import com.medicine.medicine.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter implements DtoDboConverter<OrderDto, OrderEntity> {

    private MedicineConverter medicineConverter;

    public OrderConverter(final MedicineConverter medicineConverter) {
        this.medicineConverter = medicineConverter;
    }

    @Override
    public OrderDto convertToDto(OrderEntity dbo) {
        final OrderDto orderDto = new OrderDto();
        orderDto.setId(dbo.getId());
        orderDto.setMedicineDtoList(medicineConverter.convertToDto(dbo.getMedicineEntityList()));
        return orderDto;
    }

    @Override
    public OrderEntity convertToDbo(OrderDto dto) {
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setMedicineEntityList(medicineConverter.convertToDbo(dto.getMedicineDtoList()));
        return orderEntity;
    }
}
