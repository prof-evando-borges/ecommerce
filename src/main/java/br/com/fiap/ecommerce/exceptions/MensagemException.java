package br.com.fiap.ecommerce.exceptions;

public class MensagemException extends RuntimeException {
    public MensagemException(String message) {
        super(message);
    }
}