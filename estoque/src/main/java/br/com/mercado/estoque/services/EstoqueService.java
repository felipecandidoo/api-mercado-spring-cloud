package br.com.mercado.estoque.services;

import br.com.mercado.estoque.configs.ProdutoClient;
import br.com.mercado.estoque.dto.ProdutoDTO;
import br.com.mercado.estoque.exceptions.ProdutoNaoEncontradoException;
import br.com.mercado.estoque.models.Estoque;
import br.com.mercado.estoque.repositories.EstoqueRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoClient produtoClient;
    @PersistenceContext
    EntityManager entityManager;


    public List<Estoque>  findAll(){
        return estoqueRepository.findAll();
    }

    public Estoque findById(Long codProd){
        return estoqueRepository.findById(codProd).orElseThrow(ProdutoNaoEncontradoException::new);
    }

    public Estoque entradaMercadoria(Long codProd, Double qtd, BigDecimal preco){
        Estoque est = findById(codProd);
        est.setQuantidade(qtd);
        est.setPrecoUnitario(preco);
        estoqueRepository.save(est);
        return est;
    }

    public void criar(Long codProd){
        Estoque est = new Estoque();
        est.setCodProd(codProd);
        estoqueRepository.save(est);
    }

    public Estoque precificar(Long codProd, BigDecimal preco){
        Estoque est = findById(codProd);
        est.setPrecoUnitario(preco);
        estoqueRepository.save(est);
        return est;
    }

    public List<Map<String, BigDecimal>> valorEst() {
        return estoqueRepository.findAll().stream()
                .map(estoque -> {
                    Map<String, BigDecimal> itemMap = new HashMap<>();
                    BigDecimal valorTotal = estoque.getPrecoUnitario().multiply(BigDecimal.valueOf(estoque.getQuantidade()));
                    itemMap.put("ProdutoID: " + estoque.getCodProd(), valorTotal);
                    return itemMap;
                })
                .collect(Collectors.toList());
    }

    public List<Map<String, Double>> pesoTotalPorItem() {
        return estoqueRepository.findAll().stream()
                .map(estoque -> {
                    Map<String, Double> pesoMap = new HashMap<>();
                    ProdutoDTO produto = produtoClient.findById(estoque.getCodProd()); // Usando Feign para pegar o produto
                    double pesoTotal = produto.getPeso() * estoque.getQuantidade();
                    pesoMap.put("ProdutoID: " + estoque.getCodProd(), pesoTotal);
                    return pesoMap;
                })
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> obterValorEstoque() {
        String sql = "SELECT \n" +
                "    p.codprod, \n" +
                "    p.descricao, \n" +
                "    e.quantidade, \n" +
                "    p.peso,\n" +
                "    e.precounit, \n" +
                "    FLOOR((e.quantidade * e.precounit) * 100) / 100 AS valortotal,\n" +
                "    FLOOR((e.quantidade * p.peso) * 100) / 100 AS pesototal,\n" +
                "    p.dtvencimento,\n" +
                "    (p.dtvencimento - CURRENT_DATE) AS dias_para_vencer\n" +
                "FROM produto p, estoque e\n" +
                "WHERE p.codprod = e.codprod";

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        return results.stream().map(result -> {
            Map<String, Object> map = new HashMap<>();
            map.put("codprod", result[0]);
            map.put("descricao", result[1]);
            map.put("quantidade", result[2]);
            map.put("peso", result[3]);
            map.put("precounit", result[4]);
            map.put("valortotal", result[5]);
            map.put("pesototal", result[6]);
            map.put("dtvencimento", result[7]);
            map.put("diaParaVencer", result[8]);
            return map;
        }).toList();
    }


}
