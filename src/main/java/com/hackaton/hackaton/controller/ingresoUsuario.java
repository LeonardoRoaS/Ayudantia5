package com.hackaton.hackaton.controller;

import com.hackaton.hackaton.model.Usuario;
import com.hackaton.hackaton.model.data.DBConnector;
import com.hackaton.hackaton.model.data.dao.UsuarioDAO;
import com.hackaton.hackaton.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.Log;
import org.jooq.Null;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ingresoUsuario", value = "/ingresoUsuario")
public class ingresoUsuario extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/ingresoUsuario.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        if (req.getParameter("correo").length() == 0 || req.getParameter("contraseña").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/ingresoUsuarioErroneo.jsp");
            respuesta.forward(req, resp);
        } else {
            String correo = req.getParameter("correo");
            String contraseña = req.getParameter("contraseña");
            boolean estaRegistrado = authenticate(correo, contraseña);
            if (estaRegistrado){

                    req.setAttribute("usuario",buscarUsuarioBD(correo));






                RequestDispatcher respuesta = req.getRequestDispatcher("/perfilUsuario.jsp");
                respuesta.forward(req, resp);
            }else{
                RequestDispatcher respuesta = req.getRequestDispatcher("/ingresoUsuarioErroneo.jsp");
                respuesta.forward(req, resp);
            }
        }
    }

    public boolean authenticate(String correo, String contraseña) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isAuthenticated = false;

        try {
            connection = DBConnector.connection("UsuariosDB", "root", "");
            String query = "SELECT contraseña FROM Usuario WHERE correo = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, correo);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("contraseña");
                isAuthenticated = contraseña.equals(storedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnector.closeConnection();
        }

        return isAuthenticated;
    }

    public static Usuario buscarUsuarioBD(String correo) {
        try {
            DSLContext query = DBGenerator.conectarBD("UsuariosDB");
            Usuario usuario = UsuarioDAO.obtenerUsuarioPorCorreo(query, correo);
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
