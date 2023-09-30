package com.api.carlosautopecas.login.input;

import lombok.Data;

@Data
public class LoginCreateInput {

    private String login;

    private String senha;
    private String nome;

    private String role;
}
