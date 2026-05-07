package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Categoria;
import br.com.fiap.ecommerce.services.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarTodas();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @PutMapping
    public Categoria atualizar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        categoriaService.deletar(id);
    }
}