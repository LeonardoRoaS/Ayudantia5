package com.hackaton.hackaton.controller;

import com.hackaton.hackaton.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "perfilUsuario", value = "/perfilUsuario")
public class perfilUsuario extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/perfilUsuario.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
