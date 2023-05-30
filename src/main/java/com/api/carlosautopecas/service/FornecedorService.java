package com.api.carlosautopecas.service;

import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.repository.FornecedorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ObjectMapper objectMapper;

    public FornecedorOutput findById(Integer id) throws Exception {
        if (id == null) {
            return FornecedorOutput.builder()
                    .cnpj("")
                    .nome("")
                    .nomeFantasia("")
                    .build();
        } else {
            return fornecedorRepository.findById(id)
                    .map(fornecedorEntity -> objectMapper.convertValue(fornecedorEntity, FornecedorOutput.class))
                    .orElseThrow(() -> new Exception("Fornecedor não encontrado!"));
        }
    }
}