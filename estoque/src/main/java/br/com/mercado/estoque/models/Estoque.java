package br.com.mercado.estoque.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Estoque {
    @Id
    @Column(name = "codprod")
    private Long codProd; // Refere-se ao Produto
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "precounit")
    private BigDecimal precoUnitario;

}
