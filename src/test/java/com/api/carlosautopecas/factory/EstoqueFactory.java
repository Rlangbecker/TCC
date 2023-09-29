package com.api.carlosautopecas.factory;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.output.EstoqueOutput;
import org.springframework.data.domain.Page;

public class EstoqueFactory {
    public static EstoqueEntity getEstoqueEntity() {

        EstoqueEntity estoqueEntity = new EstoqueEntity();
        estoqueEntity.setCasaPeca("z-20");
        estoqueEntity.setCsosn("505");
        estoqueEntity.setNcm("5405");
        estoqueEntity.setIdIdentificador(1L);
        estoqueEntity.setQuantidadePeca(20);
        estoqueEntity.setReferenciaPeca("40307");

        return estoqueEntity;
    }

    public static EstoqueOutput getEstoqueOutput() {

        EstoqueOutput estoqueOutput = EstoqueOutput.builder()
                .casaPeca("z-20")
                .csosn("505")
                .ncm("5405")
                .idIdentificador(1L)
                .quantidadePeca(20)
                .referenciaPeca("40307")
                .build();


        return estoqueOutput;
    }

    public static EstoqueOutput getEstoqueOutput2() {

        EstoqueOutput estoqueOutput = EstoqueOutput.builder()
                .casaPeca("z-22")
                .csosn("505")
                .ncm("5405")
                .idIdentificador(1L)
                .quantidadePeca(5)
                .referenciaPeca("40307")
                .build();


        return estoqueOutput;
    }
}
