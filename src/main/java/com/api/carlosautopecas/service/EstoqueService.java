package com.api.carlosautopecas.service;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstoqueService {


    private final EstoqueRepository estoqueRepository;

    private static final int DESCENDING = 1;

    public EstoqueEntity findById(Long id) throws RegraDeNegocioException {
        return estoqueRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("erro"));
    }

    public List<EstoqueOutput> findByReferencia(String referencia) throws RegraDeNegocioException {
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

    public Page<EstoqueEntity> retornarPaginacaoEstoque(PageRequest pageRequest, String referencia){
        return estoqueRepository.findByReferenciaPecaContainsIgnoreCase(referencia, pageRequest);
    }
}
