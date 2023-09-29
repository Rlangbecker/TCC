package com.api.carlosautopecas;

import com.api.carlosautopecas.entity.EstoqueEntity;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.factory.EstoqueFactory;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.repository.EstoqueRepository;
import com.api.carlosautopecas.service.EstoqueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EstoqueServiceTest {
    @InjectMocks
    private EstoqueService estoqueService;

    @Mock
    private EstoqueRepository estoqueRepository;


    @Test
    public void deveTestarFindByIdComSucesso() throws RegraDeNegocioException {

        when(estoqueRepository.findById(any()))
                .thenReturn(Optional.of(EstoqueFactory.getEstoqueEntity()));

        EstoqueEntity estoqueRetorno = estoqueService.findById(1l);

        assertEquals(estoqueRetorno.getIdIdentificador(), EstoqueFactory.getEstoqueEntity().getIdIdentificador());
    }

    @Test
    public void deveTestarFindByRefenciaComSucesso() throws RegraDeNegocioException {
        List<Optional<EstoqueEntity>> listEntity = new ArrayList<>();
        Optional<EstoqueEntity> estoque = Optional.of(EstoqueFactory.getEstoqueEntity());
        listEntity.add(estoque);

        List<EstoqueOutput> list = new ArrayList<>();
        list.add(EstoqueFactory.getEstoqueOutput());

        when(estoqueRepository.findByReferenciaPecaContainsIgnoreCase(any()))
                .thenReturn(listEntity);

        // Test the method
        List<EstoqueOutput> result = estoqueService.findByReferencia("4307");
        assertEquals(1, result.size());

        // Verify that the repository method was called
        verify(estoqueRepository, times(1)).findByReferenciaPecaContainsIgnoreCase("4307");


    }
}
