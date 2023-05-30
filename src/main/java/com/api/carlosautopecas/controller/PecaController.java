package com.api.carlosautopecas.controller;


import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.output.PageOutput;
import com.api.carlosautopecas.output.PecaOutput;
import com.api.carlosautopecas.service.PecaService;
import lombok.RequiredArgsConstructor;
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
                                       @RequestParam(defaultValue = "20", required = false) Integer tamanho,
                                       @RequestParam(defaultValue = "codigoPeca", required = false) String sort,
                                       @RequestParam(defaultValue = "0", required = false) Integer order) throws Exception {
        return pecaService.listaAllPaginado(pagina, tamanho, sort, order);
    }


    @GetMapping("/codigo/{codigoPeca}")
    public PecaOutput findById(@PathVariable("codigoPeca") Long codigPeca) throws Exception {
        return pecaService.findById(codigPeca);
    }

    @GetMapping("/referencia/{referencia}")
    public List<PecaOutput> findByReferencia(@PathVariable("referencia") String referencia) throws Exception {
        return pecaService.findByReferencia(referencia);
    }
}
