package com.api.carlosautopecas.login.service;

import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.input.LoginChangePassword;
import com.api.carlosautopecas.login.input.LoginCreateInput;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.input.UserOutput;
import com.api.carlosautopecas.login.output.LoginOutput;
import com.api.carlosautopecas.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;


    public LoginOutput createUser(LoginCreateInput loginInput) throws RegraDeNegocioException {

        if(loginInput==null){
            throw new RegraDeNegocioException("Os dados precisam ser preenchidos!");
        }

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
                .orElseThrow(() -> new Exception("erro! " + login));
    }

    public UserOutput findUserByLogin(String login) throws Exception {
        LoginEntity loginEntity = findByLoginEntity(login);

        return UserOutput.builder()
                .login(loginEntity.getLogin())
                .role(loginEntity.getRole())
                .nome(loginEntity.getNome())
                .build();
    }

    public Boolean changePassword(LoginChangePassword login) throws Exception {
        LoginEntity byLoginEntity = findByLoginEntity(login.getLogin());

        if (isSenhaIgual(byLoginEntity.getSenha(), login.getNovaSenha())) {
            return true;
        } else {
            byLoginEntity.setSenha(new BCryptPasswordEncoder().encode(login.getNovaSenha()));

            LoginEntity returnEntity = loginRepository.save(byLoginEntity);

            return false;
        }
    }

    public Boolean changePasswordFromUser(LoginInput loginInput) throws Exception {
        LoginEntity byLoginEntity = findByLoginEntity(loginInput.getLogin());

        byLoginEntity.setSenha(new BCryptPasswordEncoder().encode(loginInput.getSenha()));

        loginRepository.save(byLoginEntity);
        return false;
    }

    private static boolean isSenhaIgual(String hashedPassword, String novaSenha) {

        return BCrypt.checkpw(novaSenha, hashedPassword);
    }

    public List<LoginOutput> findAll(){
        return loginRepository.findAll()
                .stream()
                .map(loginEntity -> {
                    LoginOutput loginOutput = LoginOutput.builder()
                            .login(loginEntity.getLogin())
                            .role(loginEntity.getRole())
                            .nome(loginEntity.getNome())
                            .build();
                    return loginOutput;
                }).collect(Collectors.toList());
    }

}
