package com.medicine.medicine.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.medicine.medicine.service.CustomUserDetailService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.medicine.medicine.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private final CustomUserDetailService customUserDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, CustomUserDetailService customUserDetailService) {
        super(authenticationManager);
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(HEADER_STRING);
//        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request, response);
        String header = request.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthenticationToken(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_STRING);
//        if (token == null) return null;
//        String username = Jwts.parser().setSigningKey(SECRET)
//                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                .getBody()
//                .getSubject();
//        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
//        return username != null ?
//                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()) : null;

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;

    }
}
