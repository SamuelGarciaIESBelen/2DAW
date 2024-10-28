package com.example.formulario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "form", value = "/form")
public class Form extends HttpServlet {
    List<String> form = new ArrayList<>();
    String[] aficiones;

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        form.add(request.getParameter("nombre"));
        form.add(request.getParameter("apellidos"));
        form.add(request.getParameter("edad"));
        form.add(request.getParameter("peso"));
        form.add(request.getParameter("sexo"));
        form.add(request.getParameter("estadoCivil"));
        aficiones = request.getParameterValues("aficiones");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Datos formulario</h1>");
        out.println("<h2>Nombre completo: " + form.getFirst() + " " + form.get(1) + "</h2>");
        out.println("<h2>Edad: " + form.get(2) + " años</h2>");
        out.println("<h2>Peso: " + form.get(3) + " kg</h2>");
        out.println("<h2>Sexo: " + form.get(4));
        out.println("<h2>Estado civil: " + form.get(5));
        out.println("<h2>Aficiones:</h2>");
        for (String af : aficiones) {
            if (af != null) {
                out.println("<h3>&ensp;&ensp;" + af + "</h3>");
            }
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}