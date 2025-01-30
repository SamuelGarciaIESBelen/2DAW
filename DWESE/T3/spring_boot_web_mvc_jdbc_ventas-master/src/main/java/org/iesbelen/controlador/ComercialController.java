package org.iesbelen.controlador;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comercialles como
//prefijo.
@RequestMapping("/comerciales")
public class ComercialController {

	private ComercialService comercialService;

	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}

	/*@GetMapping("/")
	public String init() {
		return "redirect:/comercialles";
	}*/

	//@RequestMapping(value = "/comercialles", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping() //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comerciales/comerciales";
		
	}

	@GetMapping("/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {

		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);

		List<PedidoDTO> pedidosDTO = comercialService.listPedidosDTO(id);
		model.addAttribute("pedidosDTO", pedidosDTO);

		int totalPedidos = comercialService.getTotalPedidos();
		model.addAttribute("totalPedidos", totalPedidos);

		double porcentajePedidos = comercialService.getPorcentajePedidos(id);
		model.addAttribute("porcentajePedidos", porcentajePedidos);

		return "comerciales/detalles";
	}

	@GetMapping("/crear")
	public String crear(Model model) {

		Comercial comercial = new Comercial();
		model.addAttribute("comercial", comercial);

		return "comerciales/crear";

	}

	@PostMapping("/crear")
	public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {

		comercialService.newComercial(comercial);

		return new RedirectView("/comerciales");

	}

	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);

		return "comerciales/editar";

	}

	@PostMapping("/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {

		comercialService.updateComercial(comercial);

		return new RedirectView("/comerciales");
	}

	@PostMapping("/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {

		comercialService.deleteComercial(id);

		return new RedirectView("/comerciales");
	}

}