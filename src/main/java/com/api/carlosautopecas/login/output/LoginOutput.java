package com.api.carlosautopecas.login.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginOutput {

    private String login;

    private String role;

}
