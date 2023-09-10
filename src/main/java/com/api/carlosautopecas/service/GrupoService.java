package com.api.carlosautopecas.service;

import com.api.carlosautopecas.output.GrupoOutput;
import com.api.carlosautopecas.repository.GrupoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final ObjectMapper objectMapper;

    public GrupoOutput findById(Integer id) throws Exception {
        return grupoRepository.findById(id)
                .map(grupoEntity -> objectMapper.convertValue(grupoEntity, GrupoOutput.class))
                .orElseThrow(() -> new Exception("Grupo não encontrado"));
    }
}
