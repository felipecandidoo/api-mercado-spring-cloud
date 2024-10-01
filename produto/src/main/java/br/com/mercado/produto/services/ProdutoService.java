package br.com.mercado.produto.services;

import br.com.mercado.produto.configs.EstoqueClient;
import br.com.mercado.produto.configs.FornecedorClient;
import br.com.mercado.produto.dtos.EstoqueDTO;
import br.com.mercado.produto.models.Produto;
import br.com.mercado.produto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private EstoqueClient estoqueClient;

    public Produto createProduto(Produto produto) {
        // Pode-se validar se o fornecedor existe via FornecedorClient
        fornecedorClient.getFornecedor(produto.getCodFornec());

        Produto prod = produtoRepository.save(produto);
        System.out.println(prod);
        estoqueClient.criar(prod.getCodProd());
        return produtoRepository.save(produto);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    public Produto getProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public EstoqueDTO getEstoqueByProduto(Long codProd) {
        return estoqueClient.getEstoqueByProdutoId(codProd);
    }
}

