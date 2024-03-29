package com.api.carlosautopecas.login.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserOutput {

    private String nome;
    private String role;
    private String login;
}
