package com.api.carlosautopecas.controller.interfaceDocumentacao;

import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface InterfaceDocumentacaoPecaController {

    @Operation(summary = "Buscar lista de peças pelo nome", description = "Inserindo o nome de uma peça, como por exemplo 'bucha', retornará uma lista de peças que contenham esta palavra. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Não foram encontradas peças com este nome")
            }
    )
    @GetMapping("/descricao/{descricao}")
    public PageOutput<PecaOutput> listByName(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                             @RequestParam(defaultValue = "20", required = false) Integer tamanho,
                                             @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                             @RequestParam(defaultValue = "0", required = false) Integer order,
                                             @PathVariable("descricao") String descricao) throws RegraDeNegocioException;


    @Operation(summary = "Buscar lista de peças totais", description = "Retorna a lista de peças existentes no banco de dados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Por favor, aguarde uns instantes e tente novamente!")
            }
    )
    @GetMapping
    public PageOutput<PecaOutput> list(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                       @RequestParam(defaultValue = "10", required = false) Integer tamanho,
                                       @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                       @RequestParam(defaultValue = "0", required = false) Integer order) throws RegraDeNegocioException;


    @Operation(summary = "Buscar lista de peças pela Referência", description = "Inserindo a referência de uma peça, como por exemplo '40307', retornará uma lista de peças que contenham esta palavra. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Não foram encontradas peças com esta referência")
            }
    )
    @GetMapping("/referencia/{referencia}")
    public PageOutput<PecaOutput> listByReferencia(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                                   @RequestParam(defaultValue = "10", required = false) Integer tamanho,
                                                   @RequestParam(defaultValue = "idIdentificador", required = false) String sort,
                                                   @RequestParam(defaultValue = "0", required = false) Integer order,
                                                   @PathVariable("referencia") String referencia) throws RegraDeNegocioException;


    @Operation(summary = "Buscar uma peça pelo código específico.", description = "Inserindo o código de uma peça, como por exemplo 1001, retornará a peça existente. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Não há nenhuma peça com este código!")
            }
    )
    @GetMapping("/codigo/{codigoPeca}")
    public ResponseEntity<PecaOutput> findById(@PathVariable("codigoPeca") Long codigoPeca) throws RegraDeNegocioException;

    }
