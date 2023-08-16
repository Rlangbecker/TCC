package com.api.carlosautopecas.output;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EstoqueOutput {

    private Integer idIdentificador;

    private String casaPeca;

    private String referenciaPeca;

    private Integer quantidadePeca;

    private String ncm;

    private String csosn;
}
