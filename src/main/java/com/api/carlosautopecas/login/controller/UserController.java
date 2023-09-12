package com.api.carlosautopecas.login.controller;//package com.br.consultadeestoque.login.controller;


import com.api.carlosautopecas.login.input.LoginChangePassword;
import com.api.carlosautopecas.login.input.LoginFindIInput;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.input.UserOutput;
import com.api.carlosautopecas.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final LoginService loginService;

    @GetMapping
    public ResponseEntity<UserOutput> getLogin(String login) throws Exception {
        return new ResponseEntity<>(loginService.findUserByLogin(login), HttpStatus.OK);
    }

    @PutMapping("change-password")
    public ResponseEntity changePassword(@RequestBody LoginChangePassword loginInput) throws Exception {
        if(!loginService.changePassword(loginInput)) {
            return ResponseEntity.ok().build();
        }
       return ResponseEntity.badRequest().build();
    }

}
