package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Comentario;
import br.com.fiap.ecommerce.services.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping("/{id}")
    public Comentario buscarPorId(@PathVariable UUID id) {
        return comentarioService.buscarPorId(id);
    }

    @GetMapping
    public List<Comentario> listar() {
        return comentarioService.listar();
    }

    @PostMapping
    public Comentario salvar(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        comentarioService.deletar(id);
    }
}