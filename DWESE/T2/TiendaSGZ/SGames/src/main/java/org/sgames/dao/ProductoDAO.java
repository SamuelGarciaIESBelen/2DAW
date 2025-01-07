package org.sgames.dao;

import org.sgames.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {
	public void create(Producto producto);
	public List<Producto> getAll();
	public Optional<Producto>  find(int id);
	public void update(Producto producto);
	public void delete(int id);

	public List<Producto> filterName(String filter);
}
