package com.api.carlosautopecas.service;


import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.output.GrupoOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.repository.PecaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaRepository pecaRepository;

    private final GrupoService grupoService;

    private final FornecedorService fornecedorService;

    private final ObjectMapper objectMapper;

//        public PecaEntity findById(Long codigoPeca) {
//        Optional<PecaEntity> peca = pecaRepository.findById(codigoPeca);
//        PecaEntity pecaRetorno = objectMapper.convertValue(peca, PecaEntity.class);
//        return pecaRetorno;
//
//    }
    public List<PecaEntity> findAll() {
        return pecaRepository.findAll();
    }

    public PecaOutput findById(Long codigoPeca) throws Exception {
        PecaEntity peca = pecaRepository.findById(codigoPeca)
                .orElseThrow(() -> new Exception("Peça não encontrada!"));

        PecaOutput pecaOutput = PecaOutput.builder()
                .codigoPeca(peca.getCodigoPeca())
                .grupo(grupoService.findById(peca.getIdGrupo()).getNomeGrupo())
                .descricao(peca.getDescricao())
                .precoVenda(peca.getPrecoVenda())
                .precoCusto(peca.getPrecoCusto())
                .dataCadastro(peca.getDataCadastro())
                .ultimaVenda(peca.getUltimaVenda())
                .ultimoFornecedor(fornecedorService.findById(peca.getUltimoFornecedor()))
                .build();

        return pecaOutput;

    }

}
