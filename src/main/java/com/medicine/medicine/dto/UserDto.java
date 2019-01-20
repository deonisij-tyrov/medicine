package com.medicine.medicine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
//    private String firstName;
//    private String lastName;
    private String email;
    private String login;
    private String password;
//    private Boolean enabled;
    private Set<OrderDto> orderEntitySet = new HashSet<>();
}
