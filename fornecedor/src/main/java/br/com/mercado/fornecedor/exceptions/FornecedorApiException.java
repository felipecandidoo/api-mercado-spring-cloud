package br.com.mercado.fornecedor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FornecedorApiException extends RuntimeException{

    public ProblemDetail problemDetail(){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Internal Server Error");
        return problemDetail;
    }
}
