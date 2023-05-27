package com.api.carlosautopecas.service;

import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.repository.FornecedorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ObjectMapper objectMapper;

    public FornecedorOutput findById(Integer id) throws Exception {
        return fornecedorRepository.findById(id)
                .map(fornecedorEntity -> objectMapper.convertValue(fornecedorEntity,FornecedorOutput.class))
                .orElseThrow(() -> new Exception("Fornecedor não encontrado!"));
    }
}
