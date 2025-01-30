package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.mapstruct.PedidoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComercialService {

	private ComercialDAO comercialDAO;
	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;

	@Autowired
	private PedidoMapper pedidoMapper;

	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
		this.comercialDAO = comercialDAO;
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
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
		// ¿Está seguro de que quiere eliminar al comercial? Se borrarán también todos sus pedidos

		// Sí
		List<Pedido> pedidos = pedidoDAO.getAllByComercial(id);
		pedidos.forEach(p -> pedidoDAO.delete(p.getId()));
		comercialDAO.delete(id);

		// No
		// Borrado cancelado
	}

	public List<PedidoDTO> listPedidosDTO(int idComercial) {

		List<Cliente> clientes = clienteDAO.getAll();
		List<Pedido> pedidos = pedidoDAO.getAllByComercial(idComercial);
		pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

		List<PedidoDTO> pedidosDTO = new ArrayList<>();

		// Esto es para añadir el nombre del cliente a cada pedido, es mejor hacerlo directamente por SQL
		/*for (Pedido p : pedidos) {
			int idC = p.getIdCliente();
			for (Cliente c : clientes) {
				if (c.getId() == idC) {
					pedidosDTO.add(pedidoMapper.pedidoAPedidoDTO(p, c.getNombre() + " " + c.getApellido1()
							+ " " + (c.getApellido2() != null ? c.getApellido2() : ""), ""));
				}
			}
		}*/

		pedidos.forEach(p -> {
			int idC = p.getIdCliente();
			String nombre = clientes.stream()
					.filter(c -> c.getId() == idC)
					.map(c -> c.getNombre() + " " + c.getApellido1() + " " + (c.getApellido2() != null ? c.getApellido2() : ""))
					.findFirst().orElse("");

			pedidosDTO.add(pedidoMapper.pedidoAPedidoDTO(p, nombre, ""));
		});

		return pedidosDTO;
	}

	public int getTotalPedidos() {
		return pedidoDAO.getTotalPedidos();
	}

	public double getPorcentajePedidos(int idComercial) {
		return (double)listPedidosDTO(idComercial).size() / getTotalPedidos() * 100;
	}
}
