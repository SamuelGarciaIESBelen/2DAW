package org.iesbelen.videoclub.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    @GetMapping({"","/"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorías");
        return this.categoriaService.all();
    }

    @PostMapping({"","/"})
    public Categoria newCategoria(@Valid @RequestBody Categoria categoria, BindingResult result) {
        return this.categoriaService.save(categoria);
    }

    @GetMapping("/{id}")
    public Categoria one(@PathVariable("id") Long id) {
        return this.categoriaService.one(id);
    }

    @GetMapping("/{id}/numPeliculas")
    public int getNumPeliculas(@PathVariable("id") Long id) {
        return this.categoriaService.one(id).getPeliculas().size();
    }

    @PutMapping("/{id}")
    public Categoria replaceCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return this.categoriaService.replace(id, categoria);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id) {
        this.categoriaService.delete(id);
    }
}
