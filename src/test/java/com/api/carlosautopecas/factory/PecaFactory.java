package com.api.carlosautopecas.factory;

import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.output.PecaOutput;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PecaFactory {

    public static PecaEntity getPecaEntity() {

        PecaEntity pecaEntity = PecaEntity.builder()
                .codigoPeca(1L)
                .dataCadastro(LocalDate.now())
                .descricao("Peça do carro X")
                .idGrupo(1)
                .precoCusto(BigDecimal.valueOf(20.50))
                .precoVenda(BigDecimal.valueOf(35.00))
                .ultimaVenda(LocalDate.now())
                .ultimoFornecedor(5)
                .dataCadastro(LocalDate.of(2006,03,12))
                .build();
        return pecaEntity;
    }

    public static PecaOutput getPecaOutput(){
        PecaOutput pecaOutput = PecaOutput.builder()
                .codigoPeca(1L)
                .dataCadastro(LocalDate.now())
                .descricao("Peça do carro X")
                .grupo("Suspensao")
                .precoCusto(BigDecimal.valueOf(20.50))
                .precoVenda(BigDecimal.valueOf(35.00))
                .ultimaVenda(LocalDate.now())
                .ultimoFornecedor(FornecedorFactory.getFornecedorOutput())
                .dataCadastro(LocalDate.of(2006,03,12))
                .build();

        return pecaOutput;
    }

}
