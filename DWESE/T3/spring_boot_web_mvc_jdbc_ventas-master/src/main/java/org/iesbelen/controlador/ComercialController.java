package org.iesbelen.controlador;

import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comerciales como
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
		return "redirect:/comerciales";
	}*/

	//@RequestMapping(value = "/comerciales", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping() //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comerciales";
		
	}
}