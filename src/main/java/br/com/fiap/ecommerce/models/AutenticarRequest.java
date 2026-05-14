package br.com.fiap.ecommerce.models;

import lombok.Data;

@Data
public class AutenticarRequest {
    private String email;
    private String senha;
}