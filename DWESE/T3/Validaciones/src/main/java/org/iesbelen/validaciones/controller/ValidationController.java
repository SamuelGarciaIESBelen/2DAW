package org.iesbelen.validaciones.controller;

import jakarta.validation.Valid;
import org.iesbelen.validaciones.model.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {

	@GetMapping("/")
	public String init() {
		return "redirect:/validation";
	}

    @GetMapping("/validation")
	public String validation(@ModelAttribute Empleado empleado, Model model) {
		return "validation";
	}

	@PostMapping("/validation")
	public String postValidation(@Valid @ModelAttribute Empleado empleado, BindingResult bindingResulted, Model model) {
		model.addAttribute("empleado", empleado);
		return "validation";
	}
}
