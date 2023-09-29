package com.api.carlosautopecas.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
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
