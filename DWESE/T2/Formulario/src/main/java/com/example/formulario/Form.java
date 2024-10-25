package com.example.formulario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "form", value = "/form")
public class Form extends HttpServlet {
    List<String> formInd = new ArrayList<>();
    List<String[]> formArr = new ArrayList<>();

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        formInd.add(request.getParameter("nombre"));
        formInd.add(request.getParameter("apellidos"));
        formInd.add(request.getParameter("edad"));
        formInd.add(request.getParameter("peso"));
        formArr.add(request.getParameterValues("sexo"));
        formArr.add(request.getParameterValues("estadoCivil"));
        formArr.add(request.getParameterValues("aficiones"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Datos formulario</h1>");
        out.println("<h2>Nombre completo: " + formInd.getFirst() + " " + formInd.get(1) + "</h2>");
        out.println("<h2>Edad: " + formInd.get(2) + " años</h2>");
        out.println("<h2>Peso: " + formInd.get(3) + " kg</h2>");
        out.println("<h2>Sexo: ");
        for (int i = 0; i < formArr.getFirst().length; i++) {
            if (formArr.getFirst()[i] != null) {
                out.println(formArr.getFirst()[i] + "</h2>");
            }
        }
        out.println("<h2>Estado civil: ");
        for (int i = 0; i < formArr.get(1).length; i++) {
            if (formArr.get(1)[i] != null) {
                out.println(formArr.get(1)[i] + "</h2>");
            }
        }
        out.println("<h2>Aficiones:</h2>");
        for (int i = 0; i < formArr.get(2).length; i++) {
            if (formArr.get(2)[i] != null) {
                out.println("<h3>&ensp;&ensp;" + formArr.get(2)[i] + "</h3>");
            }
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}