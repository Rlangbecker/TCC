package com.api.carlosautopecas.service;


import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.output.GrupoOutput;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.repository.PecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaRepository pecaRepository;

    private final EstoqueService estoqueService;

    private final GrupoService grupoService;

    private final FornecedorService fornecedorService;

    private static final int DESCENDING = 1;


    public List<PecaOutput> findByReferencia(String referencia) throws Exception {
        EstoqueEntity estoqueOutput = estoqueService.findByReferencia(referencia);
        Optional<PecaEntity> pecaEntity = pecaRepository.findById(estoqueOutput.getIdIdentificador().longValue());
        PecaOutput pecaOutput = montarPecaOutput(pecaEntity.get());
        List<PecaOutput> list = new ArrayList<>();
        list.add(pecaOutput);
        return list;
    }


    public PageOutput<PecaOutput> listaAllPaginado(Integer pagina, Integer tamanho, String sort,
                                                   int order) throws Exception {
        Sort ordenacao = Sort.by(sort).ascending();
        if (order == DESCENDING) {
            ordenacao = Sort.by(sort).descending();
        }
        if (tamanho <= 0) {
            throw new Exception("O tamanho não pode ser menor do que 1.");
        }
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, ordenacao);
        Page<PecaEntity> paginaPecaEntity = pecaRepository.findAll(pageRequest);

        List<PecaOutput> pecaOutputs = paginaPecaEntity.getContent().stream()
                .map(pecaEntity -> {
                    PecaOutput pecaOutput = montarPecaOutput(pecaEntity);
                    return pecaOutput;
                }).collect(Collectors.toList());

        return new PageOutput<>(paginaPecaEntity.getTotalElements(),
                paginaPecaEntity.getTotalPages(),
                pagina,
                tamanho,
                pecaOutputs);
    }

    public PageOutput<PecaOutput> listaAllByDescricaoPaginado(Integer pagina,
                                                              Integer tamanho,
                                                              String sort,
                                                              int order,
                                                              String descricao) throws Exception {
        Sort ordenacao = Sort.by(sort).ascending();
        if (order == DESCENDING) {
            ordenacao = Sort.by(sort).descending();
        }
        if (tamanho <= 0) {
            throw new Exception("O tamanho não pode ser menor do que 1.");
        }
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, ordenacao);
        Page<PecaEntity> paginaPecaEntity;

        if (descricao != null && !descricao.isEmpty()) {
            paginaPecaEntity = pecaRepository.findByDescricaoContainingIgnoreCase(descricao, pageRequest);
        } else {
            paginaPecaEntity = pecaRepository.findAll(pageRequest);
        }

        List<PecaOutput> pecaOutputs = paginaPecaEntity.getContent().stream()
                .map(pecaEntity -> {
                    PecaOutput pecaOutput = montarPecaOutput(pecaEntity);
                    return pecaOutput;
                }).collect(Collectors.toList());

        return new PageOutput<>(paginaPecaEntity.getTotalElements(),
                paginaPecaEntity.getTotalPages(),
                pagina,
                tamanho,
                pecaOutputs);
    }


    public PecaOutput findById(Long codigoPeca) throws Exception {
        int idEstoque = codigoPeca.intValue();
        PecaEntity peca = pecaRepository.findById(codigoPeca)
                .orElseThrow(() -> new Exception("Peça não encontrada!"));

        PecaOutput pecaOutput = montarPecaOutput(peca);

        return pecaOutput;

    }

    private PecaOutput montarPecaOutput(PecaEntity pecaEntity) {
        FornecedorOutput fornecedorOutput = null;
        GrupoOutput grupoOutput = null;
        EstoqueEntity estoqueEntity = null;
        try {
            fornecedorOutput = fornecedorService.findById(pecaEntity.getUltimoFornecedor());
            grupoOutput = grupoService.findById(pecaEntity.getIdGrupo());
            estoqueEntity = estoqueService.findById(pecaEntity.getCodigoPeca().intValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        PecaOutput pecaOutput = PecaOutput.builder()
                .descricao(pecaEntity.getDescricao())
                .codigoPeca(pecaEntity.getCodigoPeca())
                .precoVenda(pecaEntity.getPrecoVenda())
                .precoCusto(pecaEntity.getPrecoCusto())
                .ultimoFornecedor(fornecedorOutput)
                .dataCadastro(pecaEntity.getDataCadastro())
                .ultimaVenda(pecaEntity.getUltimaVenda())
                .grupo(grupoOutput.getNomeGrupo())
                .estoqueEntity(estoqueEntity)
                .build();
        return pecaOutput;
    }

}
