package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Pagamento;
import java.util.ArrayList;
import java.util.List;

public class PagamentoService {

    public void inserir(Pagamento pagamento) {
        // Implementação da regra de negócio para registrar o pagamento
        // Aqui entrará a chamada para o PagamentoDAO posteriormente
    }

    public List<Pagamento> listar() {
        // Implementação para buscar os pagamentos registrados
        return new ArrayList<>();
    }

    public void atualizarStatus(String idPagamento, String novoStatus) {
        // Implementação para alterar o status de um pagamento específico
    }
}