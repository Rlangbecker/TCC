package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "TB_EST_GRUPO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
