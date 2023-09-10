package com.api.carlosautopecas.login.controller;//package com.br.consultadeestoque.login.controller;
//
//
//import com.br.consultadeestoque.login.entity.LoginEntity;
//import com.br.consultadeestoque.login.input.LoginCreateInput;
//import com.br.consultadeestoque.login.input.LoginInput;
//import com.br.consultadeestoque.login.output.LoginOutput;
//import com.br.consultadeestoque.login.service.LoginService;
//import jakarta.websocket.server.PathParam;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/login")
//public class LoginController {
//
//    private final LoginService loginService;
//
//
////    @GetMapping
////    public ResponseEntity<LoginOutput> getLogin(LoginInput login){
////        return new ResponseEntity<>(loginService.findByLogin(login.getLogin()), HttpStatus.ACCEPTED);
////    }
//
//    @PostMapping
//    public ResponseEntity<LoginOutput> createUser(LoginCreateInput login){
//        return new ResponseEntity<>(loginService.createUser(login),HttpStatus.CREATED);
//    }
//}
