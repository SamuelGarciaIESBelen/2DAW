package org.iesbelen.pruebajpa.controller;

import org.iesbelen.pruebajpa.model.Empleado;
import org.iesbelen.pruebajpa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({"", "/"})
    public List<Empleado> empleados() {
        return empleadoService.getAll();
    }

    @GetMapping("/create")
    public Empleado create() {
        return empleadoService.save(new Empleado("Samuel", "García"));
    }
}
