package com.api.carlosautopecas.service;


import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.repository.PecaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaRepository pecaRepository;

    private final ObjectMapper objectMapper;

    public PecaEntity findById(Integer id) {
        Optional<PecaEntity> peca = pecaRepository.findById(id);
        PecaEntity pecaRetorno = objectMapper.convertValue(peca, PecaEntity.class);
        return pecaRetorno;

    }

}
