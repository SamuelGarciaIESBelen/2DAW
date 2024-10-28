package com.example.da22;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        int cantidad = (int)(Math.random() * 6) + 2;
        String[] dados = { "1.svg", "2.svg", "3.svg", "4.svg", "5.svg", "6.svg" };
        int[] tirada = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            tirada[i] = (int)(Math.random() * 6);
        }

        int[] tiradaOrdenada = Arrays.copyOf(tirada, tirada.length);
        Arrays.sort(tiradaOrdenada);

        request.setAttribute("dados", dados);
        request.setAttribute("tirada", tirada);
        request.setAttribute("tiradaOrdenada", tiradaOrdenada);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}