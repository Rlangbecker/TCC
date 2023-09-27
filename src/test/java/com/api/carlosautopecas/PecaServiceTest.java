package com.api.carlosautopecas;

import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.factory.EstoqueFactory;
import com.api.carlosautopecas.factory.FornecedorFactory;
import com.api.carlosautopecas.factory.GrupoFactory;
import com.api.carlosautopecas.factory.PecaFactory;
import com.api.carlosautopecas.output.EstoqueOutput;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.repository.PecaRepository;
import com.api.carlosautopecas.service.EstoqueService;
import com.api.carlosautopecas.service.FornecedorService;
import com.api.carlosautopecas.service.GrupoService;
import com.api.carlosautopecas.service.PecaService;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PecaServiceTest {

    @InjectMocks
    private PecaService pecaService;

    @Mock
    private PecaRepository pecaRepository;
    @Mock
    private EstoqueService estoqueService;
    @Mock
    private FornecedorService fornecedorService;
    @Mock
    private GrupoService grupoService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void init() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(pecaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarFindByIdComSucesso() throws RegraDeNegocioException {

        PecaEntity pecaDeReferencia = PecaFactory.getPecaEntity();

        when(pecaRepository.findById(any()))
                .thenReturn(Optional.of(PecaFactory.getPecaEntity()));

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        when(estoqueService.findById(any()))
                .thenReturn(EstoqueFactory.getEstoqueEntity());

        PecaOutput pecaRetorno = pecaService.findById(1L);

        assertEquals(pecaRetorno.getCodigoPeca(), pecaDeReferencia.getCodigoPeca());
    }


    @Test
    public void deveTestarListAllPaginadoComSucesso() throws RegraDeNegocioException {

        Integer pagina = 0;
        Integer tamanho = 10;
        String sort = "descricao";
        int order = 1;
        Sort ordenacao = Sort.by(sort).descending();
        PecaEntity peca = PecaFactory.getPecaEntity();

        PageImpl<PecaEntity> pecaEntities = new PageImpl<>(List.of(peca),
                PageRequest.of(pagina, tamanho, ordenacao), 0);

        when(pecaRepository.findAll(any(Pageable.class)))
                .thenReturn(pecaEntities);

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        when(estoqueService.findById(any()))
                .thenReturn(EstoqueFactory.getEstoqueEntity());

        PageOutput<PecaOutput> result = pecaService.listaAllPaginado(pagina, tamanho, sort, order);

        assertEquals(pecaEntities.getTotalPages(), result.getTotalPages());

        verify(pecaRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveTestarListAllPaginadoComException() throws RegraDeNegocioException {

        Integer pagina = 0;
        Integer tamanho = -1;
        String sort = "descricao";
        int order = 1;
        Sort ordenacao = Sort.by(sort).descending();
        PecaEntity peca = PecaFactory.getPecaEntity();


        PageOutput<PecaOutput> result = pecaService.listaAllPaginado(pagina, tamanho, sort, order);

    }

    @Test
    public void deveTestarListAllByDescricaoComSucesso() throws RegraDeNegocioException {

        Integer pagina = 0;
        Integer tamanho = 10;
        String sort = "descricao";
        int order = 1;
        Sort ordenacao = Sort.by(sort).descending();
        PecaEntity peca = PecaFactory.getPecaEntity();

        PageImpl<PecaEntity> pecaEntities = new PageImpl<>(List.of(peca),
                PageRequest.of(pagina, tamanho, ordenacao), 0);

        when(pecaRepository.findByDescricaoContainingIgnoreCase(any(), any()))
                .thenReturn(pecaEntities);

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        when(estoqueService.findById(any()))
                .thenReturn(EstoqueFactory.getEstoqueEntity());

        PageOutput<PecaOutput> result = pecaService.listaAllByDescricaoPaginado(pagina, tamanho, sort, order,"Bucha");

        assertEquals(pecaEntities.getTotalPages(), result.getTotalPages());
    }

    @Test
    public void deveTestarListAllByDescricaoComDescricaoNulaComSucesso() throws RegraDeNegocioException {

        Integer pagina = 0;
        Integer tamanho = 10;
        String sort = "descricao";
        int order = 1;
        Sort ordenacao = Sort.by(sort).descending();
        PecaEntity peca = PecaFactory.getPecaEntity();

        PageImpl<PecaEntity> pecaEntities = new PageImpl<>(List.of(peca),
                PageRequest.of(pagina, tamanho, ordenacao), 0);

        when(pecaRepository.findAll(any(Pageable.class)))
                .thenReturn(pecaEntities);

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        when(estoqueService.findById(any()))
                .thenReturn(EstoqueFactory.getEstoqueEntity());

        PageOutput<PecaOutput> result = pecaService.listaAllByDescricaoPaginado(pagina, tamanho, sort, order,"");

        assertEquals(pecaEntities.getTotalPages(), result.getTotalPages());
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveTestarListAllByDescricaoPaginadoComException() throws RegraDeNegocioException {

        Integer pagina = 0;
        Integer tamanho = -1;
        String sort = "descricao";
        int order = 1;
        Sort ordenacao = Sort.by(sort).descending();
        PecaEntity peca = PecaFactory.getPecaEntity();


        PageOutput<PecaOutput> result = pecaService.listaAllByDescricaoPaginado(pagina, tamanho, sort, order,"Bucha");

    }


    @Test
    public void deveTestarFindByReferenciaComSucesso() throws RegraDeNegocioException{
    List<EstoqueOutput> listEstoqueOutput = new ArrayList<>();
    listEstoqueOutput.add(EstoqueFactory.getEstoqueOutput());


        when(estoqueService.findByReferencia(any()))
                .thenReturn(listEstoqueOutput);

        when(pecaRepository.findById(any()))
                .thenReturn(Optional.of(PecaFactory.getPecaEntity()));

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        List<PecaOutput> listPeca = pecaService.findByReferencia("40307");

        assertEquals(listPeca.size(),listEstoqueOutput.size());
    }

    @Test
    public void deveTestarFindByReferenciaComListaMairQueUmComSucesso() throws RegraDeNegocioException{
        List<EstoqueOutput> listEstoqueOutput = new ArrayList<>();
        listEstoqueOutput.add(EstoqueFactory.getEstoqueOutput());
        listEstoqueOutput.add(EstoqueFactory.getEstoqueOutput2());


        when(estoqueService.findByReferencia(any()))
                .thenReturn(listEstoqueOutput);

        when(pecaRepository.findById(any()))
                .thenReturn(Optional.of(PecaFactory.getPecaEntity()));

        when(fornecedorService.findById(any()))
                .thenReturn(FornecedorFactory.getFornecedorOutput());

        when(grupoService.findById(any()))
                .thenReturn(GrupoFactory.getGrupoOutput());

        List<PecaOutput> listPeca = pecaService.findByReferencia("40307");

        assertEquals(listPeca.size(),listEstoqueOutput.size());
    }

}
