package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cupom;
import br.com.fiap.ecommerce.exceptions.CupomException;
import br.com.fiap.ecommerce.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    public List<Cupom> listarTodos() {
        return cupomRepository.findAll();
    }

    public List<Cupom> listarAtivos() {
        return cupomRepository.findByAtivo(true);
    }

    public Cupom buscarPorId(UUID id) {
        return cupomRepository.findById(id)
                .orElseThrow(() -> new CupomException("Cupom não encontrado com id: " + id));
    }

    public Cupom buscarPorCodigo(String codigo) {
        return cupomRepository.findByCodigo(codigo)
                .orElseThrow(() -> new CupomException("Cupom não encontrado com código: " + codigo));
    }

    public Cupom salvar(Cupom cupom) {
        cupomRepository.findByCodigo(cupom.getCodigo()).ifPresent(c -> {
            throw new CupomException("Já existe um cupom com o código: " + cupom.getCodigo());
        });
        return cupomRepository.save(cupom);
    }

    public Cupom atualizar(UUID id, Cupom cupom) {
        Cupom existente = buscarPorId(id);

        cupomRepository.findByCodigo(cupom.getCodigo()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new CupomException("Já existe outro cupom com o código: " + cupom.getCodigo());
            }
        });

        existente.setCodigo(cupom.getCodigo());
        existente.setTipoDesconto(cupom.getTipoDesconto());
        existente.setValorDesconto(cupom.getValorDesconto());
        existente.setDataValidade(cupom.getDataValidade());
        existente.setQuantidadeMaxima(cupom.getQuantidadeMaxima());
        existente.setAtivo(cupom.isAtivo());

        return cupomRepository.save(existente);
    }

    public void deletar(UUID id) {
        Cupom existente = buscarPorId(id);
        cupomRepository.delete(existente);
    }

    public Cupom validarParaUso(String codigo) {
        Cupom cupom = buscarPorCodigo(codigo);

        if (!cupom.isAtivo()) {
            throw new CupomException("O cupom informado está inativo");
        }
        if (cupom.getDataValidade().isBefore(LocalDate.now())) {
            throw new CupomException("O cupom informado está expirado");
        }
        if (cupom.getQuantidadeUtilizada() >= cupom.getQuantidadeMaxima()) {
            throw new CupomException("O cupom informado atingiu o limite de utilizações");
        }

        return cupom;
    }

    public void incrementarUso(Cupom cupom) {
        cupom.setQuantidadeUtilizada(cupom.getQuantidadeUtilizada() + 1);
        if (cupom.getQuantidadeUtilizada() >= cupom.getQuantidadeMaxima()) {
            cupom.setAtivo(false);
        }
        cupomRepository.save(cupom);
    }
}