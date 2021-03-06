package com.medicine.medicine.converter;

public interface DtoDboConverter<T, B> {
    T convertToDto(final B entity);
    B convertToDbo(final T dto);
}
