package com.api.carlosautopecas.controller;


import com.api.carlosautopecas.controller.interfaceDocumentacao.InterfaceDocumentacaoPecaController;
import com.api.carlosautopecas.exception.RegraDeNegocioException;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.service.PecaService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pecas")
public class PecaController implements InterfaceDocumentacaoPecaController {

    private final PecaService pecaService;


    @GetMapping("/descricao/{descricao}")
    public PageOutput<PecaOutput> listByName(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                             @RequestParam(defaultValue = "20", required = false) Integer tamanho,
                                             @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                             @RequestParam(defaultValue = "0", required = false) Integer order,
                                             @PathVariable("descricao") String descricao) throws RegraDeNegocioException {
        return pecaService.listaAllByDescricaoPaginado(pagina, tamanho, sort, order, descricao);
    }

    @GetMapping
    public PageOutput<PecaOutput> list(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                       @RequestParam(defaultValue = "10", required = false) Integer tamanho,
                                       @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                       @RequestParam(defaultValue = "0", required = false) Integer order) throws RegraDeNegocioException {
        return pecaService.listaAllPaginado(pagina, tamanho, sort, order);
    }

    @GetMapping("/referencia/{referencia}")
    public PageOutput<PecaOutput> listByReferencia(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                       @RequestParam(defaultValue = "10", required = false) Integer tamanho,
                                       @RequestParam(defaultValue = "idIdentificador", required = false) String sort,
                                       @RequestParam(defaultValue = "0", required = false) Integer order,
                                                   @PathVariable("referencia") String referencia) throws RegraDeNegocioException {
        return pecaService.listaAllByReferencia(pagina, tamanho, sort, order,referencia);
    }


    @GetMapping("/codigo/{codigoPeca}")
    public ResponseEntity<PecaOutput> findById(@PathVariable("codigoPeca") Long codigoPeca) throws RegraDeNegocioException {
        try{
        return new ResponseEntity<>(pecaService.findById(codigoPeca), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
