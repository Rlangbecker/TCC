package com.api.carlosautopecas.service;

import com.api.carlosautopecas.exception.RegraDeNegocioException;
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

    public GrupoOutput findById(Integer id) throws RegraDeNegocioException {
        return grupoRepository.findById(id)
                .map(grupoEntity -> objectMapper.convertValue(grupoEntity, GrupoOutput.class))
                .orElseThrow(() -> new RegraDeNegocioException("Grupo não encontrado"));
    }
}
