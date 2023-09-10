package com.api.carlosautopecas.login.controller;



import com.api.carlosautopecas.login.entity.LoginEntity;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.security.TokenService;
import com.api.carlosautopecas.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public ResponseEntity<String> login(@RequestBody @Valid LoginInput loginInput){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginInput.getLogin(), loginInput.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((LoginEntity) auth.getPrincipal());

        return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid LoginInput data){
        if(loginService.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();

        loginService.createUser(data);

        return ResponseEntity.ok().build();
    }
}