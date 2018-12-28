package com.medicine.medicine.dto;

import com.medicine.medicine.entity.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private Boolean enabled;
    private List<OrderEntity> orderEntityList;
}
