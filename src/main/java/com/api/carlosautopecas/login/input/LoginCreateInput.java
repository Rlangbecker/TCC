package com.api.carlosautopecas.login.input;

import lombok.Data;

@Data
public class LoginCreateInput extends LoginInput {

    private String nome;

    private String role;
}
