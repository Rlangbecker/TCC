package com.api.carlosautopecas.controller;


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
public class PecaController {

    private final PecaService pecaService;

    @GetMapping("/descricao/{descricao}")
    public PageOutput<PecaOutput> listByName(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                             @RequestParam(defaultValue = "20", required = false) Integer tamanho,
                                             @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                             @RequestParam(defaultValue = "0", required = false) Integer order,
                                             @PathVariable("descricao") String descricao) throws Exception {
        return pecaService.listaAllByDescricaoPaginado(pagina, tamanho, sort, order, descricao);
    }

    @GetMapping
    public PageOutput<PecaOutput> list(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                       @RequestParam(defaultValue = "10", required = false) Integer tamanho,
                                       @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                       @RequestParam(defaultValue = "0", required = false) Integer order) throws Exception {
        return pecaService.listaAllPaginado(pagina, tamanho, sort, order);
    }


    @GetMapping("/codigo/{codigoPeca}")
    public ResponseEntity<PecaOutput> findById(@PathVariable("codigoPeca") Long codigoPeca) throws Exception {
        try{
        return new ResponseEntity<>(pecaService.findById(codigoPeca), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/referencia/{referencia}")
    public ResponseEntity<List<PecaOutput>> findByReferencia(@PathVariable("referencia") String referencia) throws Exception {
        try{
        return new ResponseEntity<>(pecaService.findByReferencia(referencia),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
