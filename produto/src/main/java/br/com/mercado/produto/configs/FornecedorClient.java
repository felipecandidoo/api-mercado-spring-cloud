package br.com.mercado.produto.configs;

import br.com.mercado.produto.dtos.FornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fornecedor-service")
public interface FornecedorClient {


    @GetMapping("/fornecedores/{id}")
    FornecedorDTO getFornecedor(@PathVariable("id") Long id);
}
