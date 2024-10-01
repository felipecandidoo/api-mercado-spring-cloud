package br.com.mercado.produto.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EstoqueDTO {
    private Long codProd;
    private Double quantidade;
    private BigDecimal precoUnitario;
}
