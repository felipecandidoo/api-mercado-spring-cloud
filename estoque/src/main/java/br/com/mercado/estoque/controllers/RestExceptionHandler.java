package br.com.mercado.estoque.controllers;

import br.com.mercado.estoque.exceptions.EstoqueApiException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EstoqueApiException.class)
    public ProblemDetail handleApiException(EstoqueApiException e){
        return e.problemDetail();
    }
}
