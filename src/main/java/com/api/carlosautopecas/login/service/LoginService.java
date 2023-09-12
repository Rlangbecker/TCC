package com.api.carlosautopecas.login.service;

import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.input.LoginCreateInput;
import com.api.carlosautopecas.login.output.LoginOutput;
import com.api.carlosautopecas.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;


    public LoginOutput createUser(LoginCreateInput loginInput) {

        LoginEntity login = loginRepository.save(LoginEntity.builder()
                .login(loginInput.getLogin())
                .nome(loginInput.getNome())
                .senha(new BCryptPasswordEncoder().encode(loginInput.getSenha()))
                .role(loginInput.getRole())
                .build());

        return LoginOutput.builder()
                .login(login.getLogin())
                .role(login.getRole())
                .build();
    }

    public LoginEntity findByLoginEntity(String login) throws Exception {
        return loginRepository.findByLogin(login)
                .orElseThrow(() -> new Exception("erro!"));
    }


}
