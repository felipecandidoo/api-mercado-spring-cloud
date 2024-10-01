package br.com.mercado.estoque.controllers;


import br.com.mercado.estoque.models.Estoque;
import br.com.mercado.estoque.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Retorna todos os itens no estoque
    @GetMapping
    public ResponseEntity<List<Estoque>> findAll() {
        List<Estoque> estoques = estoqueService.findAll();
        return ResponseEntity.ok(estoques);
    }

    // Retorna o item no estoque com base no código do produto
    @GetMapping("/{codProd}")
    public ResponseEntity<Estoque> findById(@PathVariable Long codProd) {
        Estoque estoque = estoqueService.findById(codProd);
        return ResponseEntity.ok(estoque);
    }

    // Registra uma entrada de mercadoria no estoque
    @PutMapping("/entrada/{codProd}")
    public ResponseEntity<Estoque> entradaMercadoria(@PathVariable Long codProd, @RequestParam Double qtd, @RequestParam BigDecimal preco) {
        Estoque estoque = estoqueService.entradaMercadoria(codProd, qtd, preco);
        return ResponseEntity.ok(estoque);
    }

    // Cria um novo registro de estoque para um produto
    @PostMapping("/criar")
    public ResponseEntity<Estoque> criar(@RequestParam Long codProd) {
        estoqueService.criar(codProd);
        return ResponseEntity.ok().build();
    }

    // Atualiza o preço unitário de um produto no estoque
    @PutMapping("/precificar/{codProd}")
    public ResponseEntity<Estoque> precificar(@PathVariable Long codProd, @RequestParam BigDecimal preco) {
        Estoque estoque = estoqueService.precificar(codProd, preco);
        return ResponseEntity.ok(estoque);
    }

    // Retorna o valor total de cada item no estoque
    @GetMapping("/valor-total")
    public ResponseEntity<List<Map<String, BigDecimal>>> valorEst() {
        List<Map<String, BigDecimal>> valorTotalEstoque = estoqueService.valorEst();
        return ResponseEntity.ok(valorTotalEstoque);
    }

    // Retorna o peso total por item no estoque
    @GetMapping("/peso-total")
    public ResponseEntity<List<Map<String, Double>>> pesoTotalPorItem() {
        List<Map<String, Double>> pesoTotal = estoqueService.pesoTotalPorItem();
        return ResponseEntity.ok(pesoTotal);
    }

    // Retorna um relatório básido dos itens em estoque
    @GetMapping("/relatorio")
    public ResponseEntity<List<Map<String, Object>>> obterValorEstoque() {
        List<Map<String, Object>> valorEstoque = estoqueService.obterValorEstoque();
        return ResponseEntity.ok(valorEstoque);
    }
}
