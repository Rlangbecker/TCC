package com.api.carlosautopecas.service;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final ObjectMapper objectMapper;

    private final EstoqueRepository estoqueRepository;

//    public List<EstoqueOutput> findByReferencia(String referencia) {
//        return estoqueRepository.findByReferenciaPeca(referencia).stream()
//                .map(estoqueEntity -> {
//                    EstoqueOutput estoqueOutput = EstoqueOutput.builder()
//                            .idIdentificador(estoqueEntity.getIdIdentificador())
//                            .referenciaPeca(estoqueEntity.getReferenciaPeca())
//                            .ncm(estoqueEntity.getNcm())
//                            .casaPeca(estoqueEntity.getCasaPeca())
//                            .quantidadePeca(estoqueEntity.getQuantidadePeca())
//                            .csosn(estoqueEntity.getCsosn())
//                            .build();
//                    return estoqueOutput;
//                })
//                .collect(Collectors.toList());
//    }

//    public EstoqueOutput findByReferencia(String referencia){
//        EstoqueOutput estoqueOutput = objectMapper.convertValue(estoqueRepository.findByReferenciaPeca(referencia), EstoqueOutput.class);
//        return estoqueOutput;
//    }

    public EstoqueEntity findById(Integer id) throws Exception {
        return estoqueRepository.findById(id).orElseThrow(() -> new Exception("erro"));
    }

    public EstoqueEntity findByReferencia(String referencia) {
        EstoqueEntity estoqueOutput = estoqueRepository.findByReferenciaPeca(referencia);
        return estoqueOutput;
    }
}
