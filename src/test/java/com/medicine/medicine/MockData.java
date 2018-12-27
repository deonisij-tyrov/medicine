package com.medicine.medicine;

import com.medicine.medicine.entity.MedicineEntity;
import com.medicine.medicine.dto.MedicineDto;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static MedicineEntity medicineDbo() {
        final MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicine("testDbo medicine");
        medicineEntity.setPrice(0);
        return medicineEntity;
    }

    public static MedicineDto medicineDto() {
        final MedicineDto medicineDto = new MedicineDto();
        medicineDto.setMedicine("testDto medicine");
        medicineDto.setPrice(0);
        return medicineDto;
    }

    public static List<MedicineDto> listDtoMedicine() {
        final List<MedicineDto> medicineDtoList = new ArrayList<>();
        medicineDtoList.add(new MedicineDto(1, "test", 1));
        medicineDtoList.add(new MedicineDto(2, "test2",0));
        return medicineDtoList;
    }
}
