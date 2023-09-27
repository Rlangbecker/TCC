package com.api.carlosautopecas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "TB_FORNECEDOR")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
