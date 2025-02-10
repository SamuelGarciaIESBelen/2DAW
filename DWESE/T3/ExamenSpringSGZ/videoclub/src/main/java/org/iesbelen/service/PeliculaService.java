package org.iesbelen.service;

import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.mapstruct.PeliculaMapper;
import org.iesbelen.model.Idioma;
import org.iesbelen.model.Pelicula;
import org.iesbelen.repository.IdiomaDAO;
import org.iesbelen.repository.PeliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {

    private PeliculaDAO peliculaDAO;

    @Autowired
    private IdiomaDAO idiomaDAO;

    @Autowired
    private PeliculaMapper peliculaMapper;

    public PeliculaService(PeliculaDAO peliculaDAO) { this.peliculaDAO = peliculaDAO; }

    public List<Pelicula> listAll() { return peliculaDAO.getAll(); }

    public void newPelicula(Pelicula pelicula) { peliculaDAO.create(pelicula); }

    public List<PeliculaDTO> listAllDTO() {
        List<Idioma> idiomas = idiomaDAO.getAll();
        List<Pelicula> peliculas = peliculaDAO.getAll();

        // Esto es para ver mejor las que creo, porque hay más de 1000
        peliculas.sort((a, b) -> b.getId_pelicula() - a.getId_pelicula());

        List<PeliculaDTO> peliculasDTO = new ArrayList<>();

        peliculas.forEach(p -> {
            int idIdioma = p.getId_idioma();
            String nombre = idiomas.stream()
                    .filter(i -> i.getId_idioma() == idIdioma)
                    .map(Idioma::getNombre)
                    .findFirst().orElse("");

            peliculasDTO.add(peliculaMapper.peliculaAPeliculaDTO(p, nombre));
        });

        return peliculasDTO;
    }
}
