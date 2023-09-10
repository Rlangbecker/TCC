package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EstoqueFornecedorId implements Serializable {

    @Column(name = "ID_ESTOQUE")
    private Long idEstoque;

    @Column(name = "ID_FORNEC")
    private Long idFornec;

    public Long getIdEstoque() {
        return idEstoque;
    }

    public Long getIdFornec() {
        return idFornec;
    }
}

