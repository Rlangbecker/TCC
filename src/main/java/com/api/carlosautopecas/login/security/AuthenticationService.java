package com.api.carlosautopecas.login.security;

import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            LoginEntity loginEntity = loginService.findByLoginEntity(username);
            return loginEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}