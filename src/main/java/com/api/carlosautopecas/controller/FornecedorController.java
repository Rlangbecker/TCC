package com.api.carlosautopecas.controller;

import com.api.carlosautopecas.output.FornecedorOutput;
import com.api.carlosautopecas.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @GetMapping("/id/{idFornecedor}")
    public ResponseEntity<FornecedorOutput> findById(@PathVariable("idFornecedor") Integer idFornecedor) throws Exception {
        return new ResponseEntity<>(fornecedorService.findById(idFornecedor), HttpStatus.ACCEPTED);
    }
}
