package org.iesbelen.controller;

import jakarta.validation.Valid;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.model.Idioma;
import org.iesbelen.model.Pelicula;
import org.iesbelen.repository.IdiomaDAO;
import org.iesbelen.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    private PeliculaService peliculaService;

    @Autowired
    private IdiomaDAO idiomaDAO;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {

        List<PeliculaDTO> listaPeliculas = peliculaService.listAllDTO();
        model.addAttribute("listaPeliculas", listaPeliculas);

        return "peliculas/peliculas";
    }

    @GetMapping("/crear")
    public String crear(Model model) {

        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);

        List<Idioma> idiomas = idiomaDAO.getAll();
        model.addAttribute("idiomas", idiomas);

        return "peliculas/crear";
    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult result, Model model) {

        if (!result.hasErrors()) {
            peliculaService.newPelicula(pelicula);
            return "redirect:/peliculas";
        }

        List<Idioma> idiomas = idiomaDAO.getAll();
        model.addAttribute("idiomas", idiomas);

        return "peliculas/crear";
    }
}
