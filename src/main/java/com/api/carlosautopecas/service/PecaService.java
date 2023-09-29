package com.api.carlosautopecas.service;


import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.output.*;
import com.api.carlosautopecas.repository.PecaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final ObjectMapper objectMapper;

    private static final int DESCENDING = 1;


    public List<PecaOutput> findByReferencia(String referencia) throws RegraDeNegocioException {
        List<EstoqueOutput> estoqueOutput = estoqueService.findByReferencia(referencia);
        List<PecaOutput> list = new ArrayList<>();

        if (estoqueOutput.size() == 1) {
            Optional<PecaEntity> pecaEntity = pecaRepository.findById(estoqueOutput.get(0).getIdIdentificador());
            PecaOutput pecaOutput = PecaOutput.builder()
                    .descricao(pecaEntity.get().getDescricao())
                    .codigoPeca(pecaEntity.get().getCodigoPeca())
                    .precoVenda(pecaEntity.get().getPrecoVenda())
                    .precoCusto(pecaEntity.get().getPrecoCusto())
                    .ultimoFornecedor(fornecedorService.findById(pecaEntity.get().getUltimoFornecedor()))
                    .dataCadastro(pecaEntity.get().getDataCadastro())
                    .ultimaVenda(pecaEntity.get().getUltimaVenda())
                    .grupo(grupoService.findById(pecaEntity.get().getIdGrupo()).getNomeGrupo())
                    .estoqueEntity(objectMapper.convertValue(estoqueOutput.get(0), EstoqueEntity.class))
                    .build();
            list.add(pecaOutput);

        } else {
            estoqueOutput.stream()
                    .forEach(estoqueOut -> {
                        Optional<PecaEntity> pecaEntity = pecaRepository.findById(estoqueOut.getIdIdentificador());
                        try {
                            PecaOutput pecaOutput = PecaOutput.builder()
                                    .descricao(pecaEntity.get().getDescricao())
                                    .codigoPeca(pecaEntity.get().getCodigoPeca())
                                    .precoVenda(pecaEntity.get().getPrecoVenda())
                                    .precoCusto(pecaEntity.get().getPrecoCusto())
                                    .ultimoFornecedor(fornecedorService.findById(pecaEntity.get().getUltimoFornecedor()))
                                    .dataCadastro(pecaEntity.get().getDataCadastro())
                                    .ultimaVenda(pecaEntity.get().getUltimaVenda())
                                    .grupo(grupoService.findById(pecaEntity.get().getIdGrupo()).getNomeGrupo())
                                    .estoqueEntity(objectMapper.convertValue(estoqueOut, EstoqueEntity.class))
                                    .build();
                            list.add(pecaOutput);
                        } catch (RegraDeNegocioException e) {

                        }
                    });


        }
        return list;

    }

    public PageOutput<PecaOutput> listaAllByReferencia(Integer pagina,
                                                       Integer tamanho,
                                                       String sort,
                                                       int order,
                                                       String referencia) throws RegraDeNegocioException {

        Sort ordenacao = Sort.by(sort).ascending();
        if (order == DESCENDING) {
            ordenacao = Sort.by(sort).descending();
        }
        if (tamanho <= 0) {
            throw new RegraDeNegocioException("O tamanho não pode ser menor do que 1.");
        }

        PageRequest pageRequest = PageRequest.of(pagina, tamanho, ordenacao);
        Page<EstoqueEntity> paginaEstoqueEntity;

        if (referencia != null && !referencia.isEmpty()) {
            paginaEstoqueEntity = estoqueService.retornarPaginacaoEstoque(pageRequest, referencia);
        } else {
            throw new RegraDeNegocioException("Sem peça encontrada por esta referencia!");
        }

        List<PecaOutput> pecaOutputs = paginaEstoqueEntity.getContent()
                .stream()
                .map(estoque -> {
                    try {
                        PecaOutput pecaOutput = findById(estoque.getIdIdentificador());

                        return pecaOutput;
                    } catch (RegraDeNegocioException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return new PageOutput<>(paginaEstoqueEntity.getTotalElements(),
                paginaEstoqueEntity.getTotalPages(),
                pagina,
                tamanho,
                pecaOutputs);
    }


    public PageOutput<PecaOutput> listaAllPaginado(Integer pagina, Integer tamanho, String sort,
                                                   int order) throws RegraDeNegocioException {
        Sort ordenacao = Sort.by(sort).ascending();
        if (order == DESCENDING) {
            ordenacao = Sort.by(sort).descending();
        }
        if (tamanho <= 0) {
            throw new RegraDeNegocioException("O tamanho não pode ser menor do que 1.");
        }
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, ordenacao);
        Page<PecaEntity> paginaPecaEntity = pecaRepository.findAll(pageRequest);

        List<PecaOutput> pecaOutputs = paginaPecaEntity.getContent().stream()
                .map(pecaEntity -> {
                    try {
                        FornecedorOutput fornecedorOutput = fornecedorService.findById(pecaEntity.getUltimoFornecedor());
                        GrupoOutput grupoOutput = grupoService.findById(pecaEntity.getIdGrupo());
                        EstoqueEntity estoqueEntity = estoqueService.findById(pecaEntity.getCodigoPeca());
                        PecaOutput pecaOutput = getBuild(estoqueEntity.getIdIdentificador(), pecaEntity);
                        return pecaOutput;
                    } catch (RegraDeNegocioException e) {
                        throw new RuntimeException(e);
                    }
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
                                                              String descricao) throws RegraDeNegocioException {
        Sort ordenacao = Sort.by(sort).ascending();
        if (order == DESCENDING) {
            ordenacao = Sort.by(sort).descending();
        }
        if (tamanho <= 0) {
            throw new RegraDeNegocioException("O tamanho não pode ser menor do que 1.");
        }
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, ordenacao);
        Page<PecaEntity> paginaPecaEntity;

        if (descricao != null && !descricao.isEmpty()) {
            paginaPecaEntity = pecaRepository.findByDescricaoContainingIgnoreCase(descricao, pageRequest);
        } else {
            paginaPecaEntity = pecaRepository.findAll(pageRequest);
        }

        List<PecaOutput> pecaOutputs = paginaPecaEntity.getContent()
                .stream()
                .map(pecaEntity -> {

                    FornecedorOutput fornecedorOutput = null;
                    GrupoOutput grupoOutput = null;
                    EstoqueEntity estoqueEntity = null;
                    try {
                        fornecedorOutput = fornecedorService.findById(pecaEntity.getUltimoFornecedor());
                        grupoOutput = grupoService.findById(pecaEntity.getIdGrupo());
                        estoqueEntity = estoqueService.findById(pecaEntity.getCodigoPeca());
                        PecaOutput pecaOutput = getBuild(estoqueEntity.getIdIdentificador(), pecaEntity);
                        return pecaOutput;
                    } catch (RegraDeNegocioException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return new PageOutput<>(paginaPecaEntity.getTotalElements(),
                paginaPecaEntity.getTotalPages(),
                pagina,
                tamanho,
                pecaOutputs);
    }


    private PecaOutput getBuild(Long idEstoque, PecaEntity peca) throws RegraDeNegocioException {

        return PecaOutput.builder()
                .codigoPeca(peca.getCodigoPeca())
                .grupo(grupoService.findById(peca.getIdGrupo()).getNomeGrupo())
                .descricao(peca.getDescricao())
                .precoVenda(peca.getPrecoVenda())
                .precoCusto(peca.getPrecoCusto())
                .dataCadastro(peca.getDataCadastro())
                .ultimaVenda(peca.getUltimaVenda())
                .ultimoFornecedor(fornecedorService.findById(peca.getUltimoFornecedor()))
                .estoqueEntity(estoqueService.findById(idEstoque))
                .build();
    }

    public PecaOutput findById(Long codigoPeca) throws RegraDeNegocioException {
        PecaEntity peca = pecaRepository.findById(codigoPeca)
                .orElseThrow(() -> new RegraDeNegocioException("Peça não encontrada!"));

        PecaOutput pecaOutput = montarPecaOutput(peca);

        return pecaOutput;
    }

    private PecaOutput montarPecaOutput(PecaEntity pecaEntity) throws RegraDeNegocioException {
        FornecedorOutput fornecedorOutput = null;
        GrupoOutput grupoOutput = null;
        EstoqueEntity estoqueEntity = null;
        try {
            fornecedorOutput = fornecedorService.findById(pecaEntity.getUltimoFornecedor());
            grupoOutput = grupoService.findById(pecaEntity.getIdGrupo());
            estoqueEntity = estoqueService.findById(pecaEntity.getCodigoPeca());
        } catch (RegraDeNegocioException e) {
            throw new RegraDeNegocioException(e.getMessage());
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
