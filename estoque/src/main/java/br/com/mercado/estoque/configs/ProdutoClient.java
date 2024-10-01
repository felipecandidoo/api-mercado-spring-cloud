package br.com.mercado.estoque.configs;

import br.com.mercado.estoque.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-service")
public interface ProdutoClient {

    @GetMapping("/produtos/find/{codProd}")
    ProdutoDTO findById(@PathVariable("codProd") Long codProd);
}
