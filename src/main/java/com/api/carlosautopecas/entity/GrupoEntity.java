package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "TB_EST_GRUPO")
public class GrupoEntity {

    @Id
    @Column(name = "ID_GRUPO")
    private Integer idGrupo;

    @Column(name = "DESCRICAO")
    private String nomeGrupo;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }
}
