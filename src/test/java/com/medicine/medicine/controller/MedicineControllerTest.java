package com.medicine.medicine.controller;


import com.medicine.medicine.MockData;
import com.medicine.medicine.service.MedicineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MedicineController.class)
public class MedicineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicineService medicineService;

    @Test

    public void createMedicine() {
    }

    @Test
//    @WithMockUser
    public void getAllMedicine() throws Exception {
//        when(medicineService.getMedicineList()).thenReturn(MockData.listDtoMedicine());
//
//        mockMvc.perform(get("/list"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.id", is(equalTo(1))))
//                .andExpect(jsonPath("$.medicine", is(equalTo("test"))))
//                .andExpect(jsonPath("$.price", is(equalTo(1))));
    }
}