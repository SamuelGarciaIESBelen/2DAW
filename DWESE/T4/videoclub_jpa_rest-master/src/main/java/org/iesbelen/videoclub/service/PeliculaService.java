package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.iesbelen.videoclub.repository.PeliculaCustomRepository;
import org.iesbelen.videoclub.repository.PeliculaRepository;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaCustomRepository peliculaCustomRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> all() {
        return this.peliculaRepository.findAll();
    }

    public Pelicula save(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    public Pelicula one(Long id) {
        return this.peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula replace(Long id, Pelicula pelicula) {
        return this.peliculaRepository.findById(id).map( p -> (id.equals(pelicula.getIdPelicula())  ?
                                                            this.peliculaRepository.save(pelicula) : null))
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public void delete(Long id) {
        this.peliculaRepository.findById(id).map(p -> { this.peliculaRepository.delete(p);
                                                        return p; })
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public List<Pelicula> findAllByOrderByTituloAsc() {
        return this.peliculaRepository.findAllByOrderByTituloAsc();
    }

    public List<Pelicula> findAllByQueryFilters(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        return this.peliculaCustomRepository.queryCustomPelicula(buscarOptional, ordenarOptional);
    }
}
