package com.api.carlosautopecas.login.controller.interfaceDocumentacao;

import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.login.input.LoginCreateInput;
import com.api.carlosautopecas.login.input.LoginInput;
import com.api.carlosautopecas.login.output.LoginOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface InterfaceDocumentacaoAuthController {

    @Operation(summary = "Fazer login", description = "Inserindo os dados de login e senha, verificará no banco estes e dados e caso existam, retornará um Token ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Verifique suas credenciais!")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginInput loginInput);


    @Operation(summary = "Registrar um novo usuário", description = "Registra um novo usuário com a opção de escolha de seu cargo ADMIN ou ATENDENTE")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Verifique os dados inseridos!")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<LoginOutput> register(@RequestBody @Valid LoginCreateInput data) throws RegraDeNegocioException;



}
