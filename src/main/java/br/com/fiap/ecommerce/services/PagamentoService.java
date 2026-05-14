package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cartao;
import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Cupom;
import br.com.fiap.ecommerce.entities.Pagamento;
import br.com.fiap.ecommerce.exceptions.CartaoException;
import br.com.fiap.ecommerce.exceptions.PagamentoException;
import br.com.fiap.ecommerce.models.MetodoPagamentoEnum;
import br.com.fiap.ecommerce.models.StatusPagamentoEnum;
import br.com.fiap.ecommerce.models.TipoDescontoEnum;
import br.com.fiap.ecommerce.repositories.CartaoRepository;
import br.com.fiap.ecommerce.repositories.ClienteRepository;
import br.com.fiap.ecommerce.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CupomService cupomService;

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public List<Pagamento> listarPorCliente(UUID idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new PagamentoException("Cliente não encontrado com id: " + idCliente));
        return pagamentoRepository.findByCliente(cliente);
    }

    public List<Pagamento> listarPorStatus(StatusPagamentoEnum status) {
        return pagamentoRepository.findByStatus(status);
    }

    public Pagamento buscarPorId(UUID id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new PagamentoException("Pagamento não encontrado com id: " + id));
    }

    public Pagamento processar(Pagamento pagamento) {
        UUID idCliente = pagamento.getCliente().getId();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new PagamentoException("Cliente não encontrado com id: " + idCliente));
        pagamento.setCliente(cliente);

        validarMetodoComCartao(pagamento);

        if (pagamento.getCartao() != null && pagamento.getCartao().getId() != null) {
            Cartao cartao = cartaoRepository.findById(pagamento.getCartao().getId())
                    .orElseThrow(() -> new CartaoException("Cartão não encontrado com id: " + pagamento.getCartao().getId()));
            if (!cartao.isAtivo()) {
                throw new CartaoException("O cartão informado está inativo");
            }
            if (!cartao.getCliente().getId().equals(idCliente)) {
                throw new CartaoException("O cartão não pertence ao cliente informado");
            }
            pagamento.setCartao(cartao);
        }

        BigDecimal desconto = BigDecimal.ZERO;

        if (pagamento.getCupom() != null && pagamento.getCupom().getId() != null) {
            Cupom cupom = cupomService.buscarPorId(pagamento.getCupom().getId());
            cupomService.validarParaUso(cupom.getCodigo());
            desconto = calcularDesconto(pagamento.getValorOriginal(), cupom);
            pagamento.setCupom(cupom);
            cupomService.incrementarUso(cupom);
        }

        pagamento.setValorDesconto(desconto);
        pagamento.setValorFinal(pagamento.getValorOriginal().subtract(desconto).max(BigDecimal.ZERO));
        pagamento.setStatus(StatusPagamentoEnum.APROVADO);

        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizarStatus(UUID id, StatusPagamentoEnum novoStatus) {
        Pagamento pagamento = buscarPorId(id);

        if (pagamento.getStatus() == StatusPagamentoEnum.CANCELADO
                || pagamento.getStatus() == StatusPagamentoEnum.ESTORNADO) {
            throw new PagamentoException("Não é possível alterar o status de um pagamento "
                    + pagamento.getStatus().name().toLowerCase());
        }

        pagamento.setStatus(novoStatus);
        return pagamentoRepository.save(pagamento);
    }

    public void deletar(UUID id) {
        Pagamento pagamento = buscarPorId(id);
        if (pagamento.getStatus() == StatusPagamentoEnum.APROVADO) {
            throw new PagamentoException(
                    "Não é possível excluir um pagamento aprovado. Utilize o cancelamento ou estorno.");
        }
        pagamentoRepository.delete(pagamento);
    }

    private void validarMetodoComCartao(Pagamento pagamento) {
        boolean requerCartao = pagamento.getMetodoPagamento() == MetodoPagamentoEnum.CARTAO_CREDITO
                || pagamento.getMetodoPagamento() == MetodoPagamentoEnum.CARTAO_DEBITO;

        if (requerCartao && (pagamento.getCartao() == null || pagamento.getCartao().getId() == null)) {
            throw new PagamentoException(
                    "É necessário informar um cartão para o método de pagamento selecionado");
        }
        if (!requerCartao && pagamento.getCartao() != null && pagamento.getCartao().getId() != null) {
            throw new PagamentoException("O método de pagamento selecionado não utiliza cartão");
        }
    }

    private BigDecimal calcularDesconto(BigDecimal valorOriginal, Cupom cupom) {
        if (cupom.getTipoDesconto() == TipoDescontoEnum.PERCENTUAL) {
            return valorOriginal.multiply(cupom.getValorDesconto())
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        }
        return cupom.getValorDesconto().min(valorOriginal);
    }
}