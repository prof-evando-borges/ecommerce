package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "CARTAO")
public class Cartao {

    // 1º Atributo: ID como UUID (VARCHAR2 no banco)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_CARTAO", updatable = false, nullable = false, length = 36)
    private String id;

    // 2º Atributo
    @NotBlank(message = "O nome do titular é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "NOME_TITULAR", nullable = false, length = 100)
    private String nomeTitular;

    // 3º Atributo
    @NotBlank(message = "O número do cartão é obrigatório")
    @Column(name = "NUMERO", nullable = false, length = 16)
    private String numero;

    // 4º Atributo
    @NotBlank(message = "O CVV é obrigatório")
    @Column(name = "CVV", nullable = false, length = 3)
    private String cvv;

    // 5º Atributo
    @NotNull(message = "A data de criação deve ser válida")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", updatable = false)
    private Date dataCriacao;

    // Lembre-se de gerar os Getters e Setters
}