package com.medicine.medicine.security;

//import com.medicine.medicine.service.CustomUserDetailService;

import com.medicine.medicine.service.CustomUserDetailService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService customUserDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(CustomUserDetailService customUserDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customUserDetailService = customUserDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/list").permitAll()
                .antMatchers("/user/list").hasRole("USER")
                .antMatchers("/order/list").hasRole("ADMIN")
                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("den").password("1234").roles("USER")
                .and()
                .withUser("admin").password("1234").roles("USER", "ADMIN");
        System.out.println(auth.inMemoryAuthentication().getUserDetailsService());

    }
}
