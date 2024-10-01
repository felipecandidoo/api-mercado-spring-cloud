package br.com.mercado.fornecedor.controllers;

import br.com.mercado.fornecedor.exceptions.FornecedorApiException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(FornecedorApiException.class)
    public ProblemDetail handleApiException(FornecedorApiException e){
        return e.problemDetail();
    }
}
