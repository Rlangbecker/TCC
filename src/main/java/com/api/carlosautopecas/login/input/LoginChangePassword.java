package com.api.carlosautopecas.login.input;

import lombok.Data;

@Data
public class LoginChangePassword {

    private String login;

    private String senha;
    private String novaSenha;
}
