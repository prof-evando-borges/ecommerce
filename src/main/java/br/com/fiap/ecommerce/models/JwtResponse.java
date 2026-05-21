package br.com.fiap.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String tipo;
    private UUID id;
    private String nome;
    private String email;
    private String role;

    public JwtResponse(String token, UUID id, String nome, String email, String role) {
        this.token = token;
        this.tipo = "Bearer";
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.role = role;
    }
}
