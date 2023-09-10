package com.api.carlosautopecas.login.service;

import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.output.LoginOutput;
import com.api.carlosautopecas.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;


    public LoginOutput createUser(LoginInput loginInput) {

        if (loginInput.getSenha().isBlank() || loginInput.getLogin().isBlank()) {

        }
        LoginEntity login = loginRepository.save(LoginEntity.builder()
                .login(loginInput.getLogin())
                .senha(new BCryptPasswordEncoder().encode(loginInput.getSenha()))
                .role("ROLE_ADMIN")
                .build());

        LoginEntity loginRetorno = loginRepository.save(login);


        return LoginOutput.builder()
                .login(loginRetorno.getLogin())
                .role(loginRetorno.getRole())
                .build();
    }

    public Boolean findByLogin(String login) {

        UserDetails user = loginRepository.findByLogin(login);

        if(user == null){
            return false;
        } else {
            return true;
        }
    }

    public UserDetails findByLoginDetails(String login) {

        UserDetails user = loginRepository.findByLogin(login);

        if(user == null){
            return null;
        } else {
            return user;
        }
    }

}
