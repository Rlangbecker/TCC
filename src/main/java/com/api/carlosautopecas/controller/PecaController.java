package com.api.carlosautopecas.controller;


import com.api.carlosautopecas.entity.PecaEntity;
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

    @GetMapping
    public List<PecaEntity> findAll(){
        return pecaService.findAll();
    }

    @GetMapping("/codigo/{codigoPeca}")
    public PecaOutput findById(@PathVariable("codigoPeca") Long codigPeca) throws Exception {
       return pecaService.findById(codigPeca);
    }
}
