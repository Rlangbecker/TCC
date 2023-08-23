package com.api.carlosautopecas.entity;

import jakarta.persistence.*;

@Entity(name = "TB_EST_FORNECEDOR")
public class EstoqueFornecedorEntity {

    @EmbeddedId
    private EstoqueFornecedorId id;

    @ManyToOne
    @JoinColumn(name = "ID_ESTOQUE", referencedColumnName = "ID_ESTOQUE")
    @MapsId("idEstoque")
    private PecaEntity estoque;

    @ManyToOne
    @JoinColumn(name = "ID_FORNEC", referencedColumnName = "ID_FORNEC")
    @MapsId("idFornec")
    private FornecedorEntity fornecedor;

    public EstoqueFornecedorId getId() {
        return id;
    }

    public PecaEntity getEstoque() {
        return estoque;
    }

    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }
}
