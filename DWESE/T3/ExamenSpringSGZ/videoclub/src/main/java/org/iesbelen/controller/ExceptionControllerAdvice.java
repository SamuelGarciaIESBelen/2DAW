package org.iesbelen.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException ex) {
        model.addAttribute("traza", ex.getMessage());
        return "error";
    }
}
