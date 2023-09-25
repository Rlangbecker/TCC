package com.api.carlosautopecas.service;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstoqueService {


    private final EstoqueRepository estoqueRepository;

    public EstoqueEntity findById(Long id) throws Exception {
        return estoqueRepository.findById(id).orElseThrow(() -> new Exception("erro"));
    }

    public List<EstoqueOutput> findByReferencia(String referencia) throws Exception {
        List<EstoqueOutput> listaEstoqueOutput = estoqueRepository.findByReferenciaPecaContainsIgnoreCase(referencia)
                .stream()
                .map(estoqueEntity -> {

                    EstoqueEntity estoque = estoqueEntity.get();
                    EstoqueOutput estoqueOutput = EstoqueOutput.builder()
                            .idIdentificador(estoque.getIdIdentificador())
                            .referenciaPeca(estoque.getReferenciaPeca())
                            .ncm(estoque.getNcm())
                            .casaPeca(estoque.getCasaPeca())
                            .quantidadePeca(estoque.getQuantidadePeca())
                            .csosn(estoque.getCsosn())
                            .build();
                    return estoqueOutput;
                }).collect(Collectors.toList());


        return listaEstoqueOutput;


    }

}
