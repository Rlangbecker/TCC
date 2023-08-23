package com.api.carlosautopecas.service;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueService {


    private final EstoqueRepository estoqueRepository;

    public EstoqueOutput findByReferencia(String referencia) throws Exception {
        EstoqueEntity estoque = estoqueRepository.findByReferenciaPeca(referencia)
                .orElseThrow(() -> new Exception("erro"));


        EstoqueOutput estoqueOutput = EstoqueOutput.builder()
                .idIdentificador(estoque.getIdIdentificador())
                .referenciaPeca(estoque.getReferenciaPeca())
                .ncm(estoque.getNcm())
                .casaPeca(estoque.getCasaPeca())
                .quantidadePeca(estoque.getQuantidadePeca())
                .csosn(estoque.getCsosn())
                .build();
        return estoqueOutput;


    }

    public EstoqueEntity findById(Integer id) throws Exception {
        return estoqueRepository.findById(id).orElseThrow(() -> new Exception("erro"));
    }
}
