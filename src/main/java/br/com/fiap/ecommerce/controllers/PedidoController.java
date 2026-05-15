package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {
    private final PedidoService pedidoService;


    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }


    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) throws InterruptedException {
        return pedidoService.salvar(pedido);
    }
}
