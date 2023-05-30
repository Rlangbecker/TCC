package com.api.carlosautopecas.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstoqueOutput {

    private Integer idIdentificador;

    private String casaPeca;

    private String referenciaPeca;

    private Integer quantidadePeca;

    private String ncm;

    private String csosn;
}
