package com.medicine.medicine.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicine.medicine.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.medicine.medicine.security.SecurityConstants.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            UserDto userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
                        UserDto userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getLogin(),
                            userDto.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
////        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC).plus(EXPIRATION_TIME, ChronoUnit.MILLIS);
//        String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
//        String token = Jwts
//                .builder()
//                .setSubject(username)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//        String bearerToken = TOKEN_PREFIX + token;
//        response.getWriter().write(bearerToken);
//        response.addHeader(HEADER_STRING, bearerToken);
        String token = JWT.create()
                .withSubject(((User) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }


}
