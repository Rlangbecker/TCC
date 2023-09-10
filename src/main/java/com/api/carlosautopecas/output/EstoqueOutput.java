package com.api.carlosautopecas.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EstoqueOutput {

    private Long idIdentificador;

    private String casaPeca;

    private String referenciaPeca;

    private Integer quantidadePeca;

    private String ncm;

    private String csosn;
}
