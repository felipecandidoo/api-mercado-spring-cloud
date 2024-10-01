package br.com.mercado.fornecedor.controllers;

import br.com.mercado.fornecedor.models.Fornecedor;
import br.com.mercado.fornecedor.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public Fornecedor getFornecedor(@PathVariable Long id) {
        return fornecedorService.getFornecedor(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Fornecedor fornecedor){
        fornecedorService.save(fornecedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

