package com.api.carlosautopecas.login.controller;


import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.input.LoginCreateInput;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.output.LoginOutput;
import com.api.carlosautopecas.login.security.TokenService;
import com.api.carlosautopecas.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final LoginService loginService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginInput loginInput) {
        try {
            UsernamePasswordAuthenticationToken userAuthDTO = new UsernamePasswordAuthenticationToken(loginInput.getLogin(), loginInput.getSenha());
            Authentication authentication = authenticationManager.authenticate(userAuthDTO);
            Object principal = authentication.getPrincipal();
            LoginEntity login = (LoginEntity) principal;
            String token = tokenService.generateToken(login);

            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Verifique suas credenciais!", HttpStatus.FORBIDDEN);
        }


    }

    @PostMapping("/register")
    public ResponseEntity<LoginOutput> register(@RequestBody @Valid LoginCreateInput data) {

        LoginOutput loginOutput = loginService.createUser(data);

        return new ResponseEntity<>(loginOutput, HttpStatus.CREATED);
    }
}