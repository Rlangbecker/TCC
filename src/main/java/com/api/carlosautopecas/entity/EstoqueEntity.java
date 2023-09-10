package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "TB_EST_PRODUTO")
public class EstoqueEntity {

    @Id
    @Column(name = "ID_IDENTIFICADOR")
    private Long idIdentificador;

    @Column(name = "DESC_CMPL")
    private String casaPeca;

    @Column(name = "REFERENCIA")
    private String referenciaPeca;

    @Column(name = "QTD_ATUAL")
    private Integer quantidadePeca;

    @Column(name = "COD_NCM")
    private String ncm;

    @Column(name = "CSOSN")
    private String csosn;


    public Long getIdIdentificador() {
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
