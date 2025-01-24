package org.iesbelen.service;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercialService {

	private ComercialDAO comercialDAO;
	private PedidoDAO pedidoDAO;

	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO) {
		this.comercialDAO = comercialDAO;
		this.pedidoDAO = pedidoDAO;
	}
	
	public List<Comercial> listAll() {
		
		return comercialDAO.getAll();
		
	}

	public Comercial one(Integer id) {
		Optional<Comercial> optCom = comercialDAO.find(id);
		if (optCom.isPresent())
			return optCom.get();
		else
			return null;
	}

	public void newComercial(Comercial comercial) {

		comercialDAO.create(comercial);

	}

	public void updateComercial(Comercial comercial) {

		comercialDAO.update(comercial);

	}

	public void deleteComercial(int id) {

		comercialDAO.delete(id);

	}

	public List<Pedido> listPedidos(int id) {

		List<Pedido> pedidos = pedidoDAO.getAllByComercial(id);
		pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

		return pedidos;
	}

}
