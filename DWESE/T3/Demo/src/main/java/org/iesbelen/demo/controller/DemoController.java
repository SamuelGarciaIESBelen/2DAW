package org.iesbelen.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.iesbelen.demo.model.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/demoth1")
    public String demoTH1(Model model) {
        String res = "A lo largo y ancho entre el Cielo y la Tierra, yo soy el único que merece ser venerado";
        model.addAttribute("res", res);

        return "demoth1";
    }

    @GetMapping("/demoth2")
    public String demoTH2(Model model) {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya"));
        libros.add(new Libro(2, "Crimen y Castigo", "Fedor Dostoievski", "Santillana"));
        libros.add(new Libro(3, "Oliver Twist", "Charles Dickens", "Tusquests"));

        model.addAttribute(libros); // Es equivalente a :
        // model.addAttribute("libroList", libros);

        return "demoth2";
    }

    @GetMapping("/demoth3")
    public String demoTH3(Model model, HttpSession session) {
        String variable = "Esto es una variable normal";
        model.addAttribute("variable", variable);

        String variableSesion = "Esto es una variable de sesión";
        session.setAttribute("variableSesion", variableSesion);

        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");
        session.setAttribute("quijote", libro);

        return "demoth3";
    }

    @GetMapping("/demoth4")
    public String demoTH4(Model model) {
        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");
        model.addAttribute("libro", libro);

        return "demoth4";
    }

    @GetMapping("/demoth5")
    public String demoTH5(Model model) {
        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");
        model.addAttribute("libro", libro);

        return "demoth5";
    }

    @GetMapping("/demoth6")
    public String demoTH6(Model model) {
        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");
        model.addAttribute("libro", libro);

        return "demoth6";
    }

    @GetMapping("/demoth7")
    public String demoTH7(Model model) { return "demoth7"; }

    @GetMapping("/demoth8")
    public String demoTH8(Model model) { return "demoth8"; }

    @GetMapping("/demoth9")
    public String demoTH9(Model model) { return "demoth9"; }

    @GetMapping("/demoth10")
    public String demoTH10(Model model) { return "demoth10"; }
    
}
