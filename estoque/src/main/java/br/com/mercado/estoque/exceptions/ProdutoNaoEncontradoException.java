package br.com.mercado.estoque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProdutoNaoEncontradoException extends EstoqueApiException{

    @Override
    public ProblemDetail problemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Produto não encontrado!");
        problemDetail.setDetail("Por favor, insira um codProd válido!");
        return problemDetail;
    }
}
