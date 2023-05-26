package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "TB_ESTOQUE")
public class PecaEntity {

    @Id
    @Column(name = "ID_ESTOQUE")
    private Long idPeca;

    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "PRC_VENDA")
    private BigDecimal precoVenda;

    @Column(name = "PRC_CUSTO")
    private BigDecimal precoCusto;

    @Column(name = "DT_CADAST")
    private LocalDate dataCadastro;
    @Column(name = "ULT_VENDA")
    private LocalDate ultimaVenda;

    public Long getIdPeca() {
        return idPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getUltimaVenda() {
        return ultimaVenda;
    }

    public void setUltimaVenda(LocalDate ultimaVenda) {
        this.ultimaVenda = ultimaVenda;
    }
}
