package com.medicine.medicine.service;

import com.medicine.medicine.dto.UserDto;
import com.medicine.medicine.entity.UserEntity;
import com.medicine.medicine.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyList;

@Component
@Data
public class CustomUserDetailService implements UserDetailsService {
    UserRepository userRepository;

//    public UserDto loadApplicationUserByUserName(String userName) {
//        UserDto userDto = new UserDto();
//        userDto.setLogin("user");
//        userDto.setPassword("user");
//        return userDto;
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLogin(login);
        if (userEntity == null) {
            throw new UsernameNotFoundException(login);
        }
//        return new User(userEntity.getLogin(), userEntity.getPassword(), emptyList());
        return new User("den", "1234", emptyList());
    }
}