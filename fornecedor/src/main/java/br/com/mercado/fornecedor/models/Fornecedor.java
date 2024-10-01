package br.com.mercado.fornecedor.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codfornec")
    private Long codFornec;
    @Column(name = "fornecedor")
    private String fornecedor;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;

}

