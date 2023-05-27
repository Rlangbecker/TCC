package com.api.carlosautopecas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "TB_EST_PRODUTO")
public class EstoqueEntity {

    @Id
    @Column(name = "ID_IDENTIFICADOR")
    private Integer idIdentificador;

    @Column(name = "DESC_COMPL")
    private String casaPeca;

    @Column(name = "REFERENCIA")
    private String referenciaPeca;

    @Column(name = "QTD_ATUAL")
    private Integer quantidadePeca;

    @Column(name = "COD_NCM")
    private String ncm;

    @Column(name = "CSOSN")
    private String csosn;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "TB_EST_PROODUTO",
//            joinColumns = @JoinColumn(name = "ID_IDENTIFICADOR"),
//            inverseJoinColumns = @JoinColumn(name = "ID_ESTOQUE"))
//    private Set<PecaEntity> pecaEntity;

//    public Set<PecaEntity> getPecaEntity() {
//        return pecaEntity;
//    }

    public Integer getIdIdentificador() {
        return idIdentificador;
    }

    public String getCasaPeca() {
        return casaPeca;
    }

    public String getReferenciaPeca() {
        return referenciaPeca;
    }

    public Integer getQuantidadePeca() {
        return quantidadePeca;
    }

    public String getNcm() {
        return ncm;
    }

    public String getCsosn() {
        return csosn;
    }
}
