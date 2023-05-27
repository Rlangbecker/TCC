package com.api.carlosautopecas.output;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class PecaOutput {

    private Long codigoPeca;

    private String grupo;

    private String descricao;

    private BigDecimal precoVenda;

    private BigDecimal precoCusto;

    private LocalDate dataCadastro;

    private LocalDate ultimaVenda;

    private FornecedorOutput ultimoFornecedor;


}
