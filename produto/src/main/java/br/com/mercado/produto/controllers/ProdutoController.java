package br.com.mercado.produto.controllers;

import br.com.mercado.produto.dtos.EstoqueDTO;
import br.com.mercado.produto.dtos.ProdutoDTO;
import br.com.mercado.produto.models.Produto;
import br.com.mercado.produto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private Environment env;

    @PostMapping
    public ResponseEntity<?> createProduto(@RequestBody Produto produto) {
        try {
            produtoService.createProduto(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable Long id) {
        ProdutoDTO response = ProdutoDTO.builder()
                .result(produtoService.getProduto((id)))
                .port(env.getProperty("local.server.port"))
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {

        return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/estoque")
    public EstoqueDTO getEstoqueByProduto(@PathVariable Long id) {
        return produtoService.getEstoqueByProduto(id);
    }
}

