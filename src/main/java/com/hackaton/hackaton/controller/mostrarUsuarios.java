package com.hackaton.hackaton.controller;

import com.hackaton.hackaton.model.data.dao.UsuarioDAO;
import com.hackaton.hackaton.model.Usuario;
import com.hackaton.hackaton.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mostrarUsuarios", value = "/mostrarUsuarios")
public class mostrarUsuarios extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("usuarios",agregarUsuarios());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarUsuarios.jsp");
        respuesta.forward(req,resp);
    }

    private List agregarUsuarios() throws ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = UsuarioDAO.obtenerUsuarios(DBGenerator.conectarBD("UsuariosDB"));
        return usuarios;
    }

}
