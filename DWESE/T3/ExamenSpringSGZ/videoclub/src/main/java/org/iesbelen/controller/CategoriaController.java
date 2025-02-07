package org.iesbelen.controller;

import org.iesbelen.model.Categoria;
import org.iesbelen.service.CategoriaService;
import org.iesbelen.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final PeliculaService peliculaService;
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService, PeliculaService peliculaService) { this.categoriaService = categoriaService;
        this.peliculaService = peliculaService;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {

        List<Categoria> listaCategorias = categoriaService.listAll();
        model.addAttribute("listaCategorias", listaCategorias);

        return "categorias/categorias";
    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id) {

        Categoria categoria = categoriaService.one(id);
        model.addAttribute("categoria", categoria);

        /*int totalPeliculas = categoriaService.getTotalPeliculas(id);
        model.addAttribute("totalPeliculas", totalPeliculas);

        double mediaDuracion = categoriaService.getDuracionMedia(id);
        model.addAttribute("mediaDuracion", mediaDuracion);*/

        return "categorias/detalles";
    }
}
