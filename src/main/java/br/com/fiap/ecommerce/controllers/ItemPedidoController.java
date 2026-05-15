package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.ItemPedido;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.services.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/itempedido")
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;


    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping("/{id}")
    public ItemPedido buscarPorId(@PathVariable UUID id) {
        return itemPedidoService.buscarPorId(id);
    }
    @GetMapping
    public List<ItemPedido> listarTodos() {
        return itemPedidoService.listarTodos();
    }

    @PostMapping
    public ItemPedido salvar(@RequestBody ItemPedido itemPedido) throws InterruptedException {
        return ItemPedidoService.salvar(itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
