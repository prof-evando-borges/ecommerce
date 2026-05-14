package br.com.fiap.ecommerce.exceptions;

public class CartaoException extends RuntimeException {
    public CartaoException(String message) {
        super(message);
    }
}