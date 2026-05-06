package br.com.fiap.ecommerce.model;
 
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
 
@Entity[cite: 2]
@Table(name = "CARTAO")[cite: 2]
public class Cartao {
 
    @Id[cite: 2]
    @GeneratedValue(strategy = GenerationType.IDENTITY)[cite: 2]
    @Column(name = "ID_CARTAO")[cite: 2]
    private Long id;
 
    @NotBlank(message = "O nome do titular é obrigatório")[cite: 2]
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")[cite: 2]
    @Column(name = "NOME_TITULAR", nullable = false, length = 100)[cite: 2]
    private String nomeTitular;
 
    @NotBlank(message = "O número do cartão é obrigatório")[cite: 2]
    @Column(name = "NUMERO", nullable = false, length = 16)[cite: 2]
    private String numero;
 
    @NotBlank(message = "O CVV é obrigatório")[cite: 2]
    @Column(name = "CVV", nullable = false, length = 3)[cite: 2]
    private String cvv;
 
    @NotNull(message = "A data de criação deve ser válida")[cite: 2]
    @Temporal(TemporalType.TIMESTAMP)[cite: 2]
    @Column(name = "DATA_CRIACAO", updatable = false)[cite: 2]
    private Date dataCriacao;
 
}