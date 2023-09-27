package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "TB_ESTOQUE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PecaEntity {

    @Id
    @Column(name = "ID_ESTOQUE")
    private Long codigoPeca;

    @Column(name = "ID_GRUPO")
    private Integer idGrupo;

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

    @Column(name = "ULT_FORNEC")
    private Integer ultimoFornecedor;

    public Long getCodigoPeca() {
        return codigoPeca;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getUltimaVenda() {
        return ultimaVenda;
    }

    public Integer getUltimoFornecedor() {
        return ultimoFornecedor;
    }


}
