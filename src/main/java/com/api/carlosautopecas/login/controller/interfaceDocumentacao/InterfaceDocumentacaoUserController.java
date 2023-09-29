package com.api.carlosautopecas.login.controller.interfaceDocumentacao;

import com.api.carlosautopecas.login.input.UserOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface InterfaceDocumentacaoUserController {

    @Operation(summary = "Buscar usuário por Login", description = "Inserindo os dados de login e senha, verificará no banco estes e dados e caso existam, retornará um Token ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Verifique suas credenciais!")
            }
    )
    public ResponseEntity<UserOutput> getByLogin(@PathVariable("login") String login) throws Exception;


    }
