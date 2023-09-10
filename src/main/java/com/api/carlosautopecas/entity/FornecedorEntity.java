package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "TB_FORNECEDOR")
public class FornecedorEntity {
    @Id
    @Column(name = "ID_FORNEC")
    private Integer idFornecedor;

    @Column(name = "NOME")
    private String nome;
    @Column(name = "NOME_FANTA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private String cnpj;

//    @JsonIgnoreProperties
//    @OneToOne
//    @JoinColumn(name = "ID_ESTOQUE",referencedColumnName = "ID_ESTOQUE")
//    private PecaEntity peca;
//
//    public PecaEntity getPeca() {
//        return peca;
//    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

//    public Set<PecaEntity> getPecas() {
//        return pecas;
//    }
}
