package org.iesbelen.service;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.modelo.Comercial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialService {

	private ComercialDAO comercialDAO;

	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialService(ComercialDAO comercialDAO) {
		this.comercialDAO = comercialDAO;
	}
	
	public List<Comercial> listAll() {
		
		return comercialDAO.getAll();
		
	}
	
	

}
