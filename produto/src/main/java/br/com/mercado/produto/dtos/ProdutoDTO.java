package br.com.mercado.produto.dtos;

import br.com.mercado.produto.models.Produto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {

    private Produto result;
    private String port;
}
