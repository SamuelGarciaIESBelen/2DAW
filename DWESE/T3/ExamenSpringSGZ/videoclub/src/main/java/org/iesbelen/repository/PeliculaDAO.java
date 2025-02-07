package org.iesbelen.repository;

import org.iesbelen.model.Pelicula;

import java.util.List;

public interface PeliculaDAO {
	public void create(Pelicula pelicula);
	public List<Pelicula> getAll();
	public List<Pelicula> getAllByCategoria(int id_categoria);
}
