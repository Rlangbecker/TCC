package com.api.carlosautopecas.service;

import com.api.carlosautopecas.exception.RegraDeNegocioException;
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

    public FornecedorOutput findById(Integer id) throws RegraDeNegocioException {
        if (id == null) {
            return FornecedorOutput.builder()
                    .cnpj("")
                    .nome("")
                    .nomeFantasia("")
                    .build();
        } else {

            return fornecedorRepository.findById(id)
                    .map(fornecedorEntity -> objectMapper.convertValue(fornecedorEntity, FornecedorOutput.class))
                    .orElseThrow(() -> new RegraDeNegocioException("Fornecedor não encontrado!"));
        }
    }
}
