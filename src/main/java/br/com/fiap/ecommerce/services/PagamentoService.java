package br.com.fiap.ecommerce.services;
 
import br.com.fiap.ecommerce.entities.Pagamento;
import br.com.fiap.ecommerce.repositories.PagamentoRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service[cite: 2]
public class PagamentoService {
 
    private final PagamentoRepository pagamentoRepository;
 
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }[cite: 2]
 
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }[cite: 2]
 
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }[cite: 2]
 
    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }[cite: 2]
}