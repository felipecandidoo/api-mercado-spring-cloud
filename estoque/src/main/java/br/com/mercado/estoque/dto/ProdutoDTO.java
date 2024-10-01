package br.com.mercado.estoque.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProdutoDTO {

    private Long codProd;
    private Double peso;
    private String unidade;
    private LocalDate dtVencimento;

}
