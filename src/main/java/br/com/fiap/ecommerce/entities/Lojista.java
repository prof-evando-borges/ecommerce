package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_LOJISTA")
@Data
public class Lojista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ deve conter exatamente 14 caracteres")
    @Column(name = "CNPJ", nullable = false, length = 14, unique = true)
    private String cnpj;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 200, message = "O endereço deve ter no máximo 200 caracteres")
    @Column(name = "ENDERECO", nullable = false, length = 200)
    private String endereco;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail informado é inválido")
    @Size(max = 150, message = "O e-mail deve ter no máximo 150 caracteres")
    @Column(name = "EMAIL", nullable = false, length = 150, unique = true)
    private String email;

    @NotBlank(message = "O tipo de empresa é obrigatório")
    @Size(max = 50, message = "O tipo de empresa deve ter no máximo 50 caracteres")
    @Column(name = "TIPO_EMPRESA", nullable = false, length = 50)
    private String tipoEmpresa;

    @NotBlank(message = "A categoria da empresa é obrigatória")
    @Size(max = 50, message = "A categoria da empresa deve ter no máximo 50 caracteres")
    @Column(name = "CATEGORIA_EMPRESA", nullable = false, length = 50)
    private String categoriaEmpresa;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    @Column(name = "SENHA", nullable = false)
    private String senha;
}