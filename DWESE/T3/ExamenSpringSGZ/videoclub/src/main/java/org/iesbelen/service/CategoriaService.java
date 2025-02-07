package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import org.iesbelen.model.Pelicula;
import org.iesbelen.repository.CategoriaDAO;
import org.iesbelen.model.Categoria;
import org.iesbelen.repository.PeliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaDAO categoriaDAO;

    @Autowired
    private PeliculaDAO peliculaDAO;

    public CategoriaService(CategoriaDAO categoriaDAO) { this.categoriaDAO = categoriaDAO; }

    public List<Categoria> listAll() { return categoriaDAO.getAll(); }

    public Categoria one(Integer id) {
        Optional<Categoria> optCat = categoriaDAO.find(id);
        if (optCat.isPresent())
            return optCat.get();
        else
            return null;
    }

    public int getTotalPeliculas(int id_categoria) {
        return peliculaDAO.getAllByCategoria(id_categoria).size();
    }

    public double getDuracionMedia(int id_categoria) {
        List<Pelicula> peliculas = peliculaDAO.getAllByCategoria(id_categoria);
        return peliculas.stream().mapToDouble(Pelicula::getDuracion).average().orElse(0);
    }
}
