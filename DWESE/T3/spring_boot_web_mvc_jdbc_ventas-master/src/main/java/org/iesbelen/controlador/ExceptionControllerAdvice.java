package org.iesbelen.controlador;

import org.iesbelen.exception.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MiExcepcion.class)
    public String handleMiException(Model model, MiExcepcion ex) {

        model.addAttribute("traza", ex.getMessage());
        return "excepciones/errorMiException";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException ex) {
        model.addAttribute("traza", ex.getMessage());
        return "excepciones/errorRunTimeException";
    }

}
