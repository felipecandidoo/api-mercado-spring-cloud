package br.com.mercado.produto.dtos;

import lombok.Data;

@Data
public class FornecedorDTO {
    private Long codFornec;
    private String fornecedor;
    private String cnpj;
}
