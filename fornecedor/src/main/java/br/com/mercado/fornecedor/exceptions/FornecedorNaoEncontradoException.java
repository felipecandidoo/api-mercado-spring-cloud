package br.com.mercado.fornecedor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FornecedorNaoEncontradoException extends FornecedorApiException{

    @Override
    public ProblemDetail problemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Fornecedor não encontrado");
        problemDetail.setDetail("Por favor, insira um codFornec válido");
        return problemDetail;
    }
}
