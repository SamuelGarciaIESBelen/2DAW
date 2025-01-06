package org.sgames.dao;

import org.sgames.model.Categoria;
import org.sgames.model.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {
	public void create(Categoria categoria);
	public List<Categoria> getAll();
	public Optional<Categoria>  find(int id);
	public void update(Categoria categoria);
	public void delete(int id);

	public Optional<Integer> getCountProductos(int id);
	public List<CategoriaDTO> getAllDTO();
}
