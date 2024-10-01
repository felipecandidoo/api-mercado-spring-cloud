package br.com.mercado.estoque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class EstoqueApiException extends RuntimeException{

    public ProblemDetail problemDetail(){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail("Internal Server Error");
        return problemDetail;
    }
}
