package br.com.fiap.ecommerce.models;

import lombok.Data;

@Data
public class AlterarSenhaRequest {
    private String email;
    private String senhaAtual;
    private String novaSenha;
}