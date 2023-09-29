package com.api.carlosautopecas.login.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginOutput {

    private String nome;
    private String login;

    private String role;

}
