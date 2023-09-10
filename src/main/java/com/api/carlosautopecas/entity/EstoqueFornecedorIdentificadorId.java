package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EstoqueFornecedorIdentificadorId implements Serializable {

    @Column(name = "ID_EST_FORNEC")
    private Long idEstFornec;

    @Column(name = "ID_IDENTIFICADOR")
    private Long idIdentificador;

    public Long getIdEstFornec() {
        return idEstFornec;
    }

    public Long getIdIdentificador() {
        return idIdentificador;
    }
}
