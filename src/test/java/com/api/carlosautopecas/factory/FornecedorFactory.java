package com.api.carlosautopecas.factory;

import com.api.carlosautopecas.entity.FornecedorEntity;
import com.api.carlosautopecas.output.FornecedorOutput;

public class FornecedorFactory {

    public static FornecedorOutput getFornecedorOutput() {

      FornecedorOutput fornecedorOutput = FornecedorOutput.builder()
              .cnpj("12312323")
              .nomeFantasia("Empresa COHAD")
              .nome("COHAD")
              .build();

      return fornecedorOutput;
    }

    public static FornecedorEntity getFornecedorEntity() {

        FornecedorEntity fornecedorEntity = FornecedorEntity.builder()
                .idFornecedor(1)
                .cnpj("12312323")
                .nomeFantasia("Empresa COHAD")
                .nome("COHAD")
                .build();

        return fornecedorEntity;
    }
}
