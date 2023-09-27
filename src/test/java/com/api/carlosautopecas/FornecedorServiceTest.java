package com.api.carlosautopecas;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.factory.EstoqueFactory;
import com.api.carlosautopecas.factory.FornecedorFactory;
import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import com.api.carlosautopecas.repository.FornecedorRepository;
import com.api.carlosautopecas.service.EstoqueService;
import com.api.carlosautopecas.service.FornecedorService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FornecedorServiceTest {
    @InjectMocks
    private FornecedorService fornecedorService;

    @Mock
    private FornecedorRepository fornecedorRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void init() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(fornecedorService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarFindByIdComSucesso() throws RegraDeNegocioException {

        when(fornecedorRepository.findById(any()))
                .thenReturn(Optional.of(FornecedorFactory.getFornecedorEntity()));

        FornecedorOutput fornecedorOutput = fornecedorService.findById(1);

        assertEquals(fornecedorOutput.getCnpj(), FornecedorFactory.getFornecedorEntity().getCnpj());
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveTestarFindByIdComException() throws RegraDeNegocioException {

        when(fornecedorRepository.findById(any()))
                .thenReturn(Optional.empty());

        FornecedorOutput fornecedorOutput = fornecedorService.findById(1);
    }
}
