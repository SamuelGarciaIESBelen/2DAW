package org.iesbelen.controlador;

import org.iesbelen.exception.MiExcepcion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("/runtime-exception")
    public String runtimeException() {
        throw new RuntimeException();
    }

    @GetMapping("/miexception")
    public String miException() throws MiExcepcion {
        throw new MiExcepcion();
    }
}
