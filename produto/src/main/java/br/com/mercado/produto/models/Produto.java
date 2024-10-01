package br.com.mercado.produto.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codprod")
    private Long codProd;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "codfornec")
    private Long codFornec; // Referência ao Fornecedor
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "dtvencimento")
    private LocalDate dtVencimento;

}

