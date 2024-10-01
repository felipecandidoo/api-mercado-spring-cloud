package br.com.mercado.produto.configs;

import br.com.mercado.produto.dtos.EstoqueDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "estoque-service")
public interface EstoqueClient {

    @GetMapping("/estoques/{produtoId}")
    EstoqueDTO getEstoqueByProdutoId(@PathVariable Long produtoId);

    @PostMapping("/estoques/criar")
    EstoqueDTO criar(@RequestParam Long codProd);
}
