package com.api.carlosautopecas.entity;

import jakarta.persistence.*;

@Entity(name = "TB_ESTOQUE_FORNECEDOR")
public class EstoqueFornecedorIdentificador {

    @EmbeddedId
    private EstoqueFornecedorIdentificadorId id;

    @ManyToOne
    @JoinColumn(name = "ID_EST_FORNEC", referencedColumnName = "ID_FORNEC")
    @MapsId("idFornec")
    private EstoqueFornecedorEntity estoqueFornecedor;

    @ManyToOne
    @JoinColumn(name = "ID_IDENTIFICADOR", referencedColumnName = "ID_IDENTIFICADOR")
    @MapsId("idIdentificador")
    private IdentificadorEntity identificador;

    public EstoqueFornecedorIdentificadorId getId() {
        return id;
    }

    public EstoqueFornecedorEntity getEstoqueFornecedor() {
        return estoqueFornecedor;
    }

    public IdentificadorEntity getIdentificador() {
        return identificador;
    }
}