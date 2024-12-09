package org.iesbelen.dao;

import org.iesbelen.model.Departamento;
import org.iesbelen.model.DepartamentoDTO;

import java.util.List;
import java.util.Optional;

public interface DepartamentoDAO {
		
	public void create(Departamento departamento);
	public List<Departamento> getAll();
	public Optional<Departamento> find(int id);
	/*
	public void update(Departamento departamento);
	public void delete(int id);
	*/

	public List<DepartamentoDTO> getAllDTO();
	public List<Departamento> getAllFiltered(int min,int max);

}