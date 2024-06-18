package com.hackaton.hackaton.controller;

import com.hackaton.hackaton.model.Usuario;
import com.hackaton.hackaton.model.data.DBConnector;
import com.hackaton.hackaton.model.data.DBGenerator;
import com.hackaton.hackaton.model.data.dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.util.List;

@WebServlet(name = "registroUsuario", value = "/registroUsuario")
public class registroUsuario extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        if (req.getParameter("nombre").length() == 0 || req.getParameter("contraseña").length() == 0 || req.getParameter("correo").length() == 0 || req.getParameter("numero").length() == 0 || req.getParameter("rut").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        } else {
            String nombre = req.getParameter("nombre");
            String contraseña = req.getParameter("contraseña");
            String correo = req.getParameter("correo");
            String rut = req.getParameter("rut");
            int numero = Integer.parseInt(req.getParameter("numero"));
            Usuario usuario = new Usuario(nombre,contraseña,correo,rut,numero);
            try {
                if(registrarUsuario(usuario)){
                    req.setAttribute("usuario",usuario);
                    RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                    respuesta.forward(req,resp);
                }else{
                    RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneoYaRegistrado.jsp");
                    respuesta.forward(req, resp);
                }
            } catch(ClassNotFoundException e){
                throw new RuntimeException(e);
            }

        }
    }

    public static boolean registrarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("UsuariosDB");
        List<Usuario> usuarios = UsuarioDAO.obtenerUsuario(query,"rut",usuario.getRut());
        if(usuarios.size()!=0){
            return false;
        }
        else{
            UsuarioDAO.agregarUsuario(query,usuario);
            return true;
        }
    }


}