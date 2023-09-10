package com.api.carlosautopecas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_EST_IDENTIFICADOR")
public class IdentificadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IDENTIFICADOR")
    private Long idIdentificador;

    @ManyToOne
    @JoinColumn(name = "ID_ESTOQUE")
    private PecaEntity peca;

    public Long getIdIdentificador() {
        return idIdentificador;
    }

    public PecaEntity getPeca() {
        return peca;
    }
}
