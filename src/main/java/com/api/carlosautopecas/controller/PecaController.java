package com.api.carlosautopecas.controller;


import com.api.carlosautopecas.entity.PecaEntity;
import com.api.carlosautopecas.service.PecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/peca")
public class PecaController {

    private final PecaService pecaService;

    @GetMapping("/find-by-id")
    public PecaEntity findById(@RequestParam Integer id){
       return pecaService.findById(id);
    }
}
