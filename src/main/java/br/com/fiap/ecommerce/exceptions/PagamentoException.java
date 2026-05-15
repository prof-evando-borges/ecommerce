package br.com.fiap.ecommerce.exceptions;

public class PagamentoException extends RuntimeException {
    public PagamentoException(String message) {
        super(message);
    }
}