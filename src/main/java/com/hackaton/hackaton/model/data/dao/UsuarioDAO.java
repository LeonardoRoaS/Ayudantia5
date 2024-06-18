package com.hackaton.hackaton.model.data.dao;

import com.hackaton.hackaton.model.Usuario;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class UsuarioDAO {

    public static List validarExistenciaUsuario(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaUsuario(resultados);
    }

    public static void agregarUsuario(DSLContext query, Usuario usuario){
        Table tablaUsuario = table(name("Usuario"));
        Field[] columnas = tablaUsuario.fields("nombre","contraseña","correo","rut","numero");
        query.insertInto(tablaUsuario, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(usuario.getNombre(),usuario.getContraseña(),usuario.getCorreo(),usuario.getRut(),usuario.getNumero())
                .execute();

    }

    public static List obtenerUsuario(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaUsuario(resultados);
    }
    public static List obtenerUsuarios(DSLContext query){
        Result resultados = query.select().from(DSL.table("Usuario")).fetch();
        return obtenerListaUsuario(resultados);
    }

    public static Usuario obtenerUsuarioPorCorreo(DSLContext query, String correo) {
        Result resultados = query.select().from(table("Usuario")).where(DSL.field("correo").eq(correo)).fetch();
        if (resultados.isNotEmpty()) {
            String rut = (String) resultados.getValue(0, "rut");
            String nombre = (String) resultados.getValue(0, "nombre");
            String contraseña = (String) resultados.getValue(0, "contraseña");
            String email = (String) resultados.getValue(0, "correo");
            int numero = (Integer) resultados.getValue(0, "numero");
            return new Usuario(nombre, contraseña, email, rut, numero);
        }
        return null;
    }

    private static List obtenerListaUsuario(Result resultados){
        List<Usuario> usuarios= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String contraseña = (String) resultados.getValue(fila,"contraseña");
            String correo = (String) resultados.getValue(fila,"correo");
            int numero = (Integer) resultados.getValue(fila,"numero");
            usuarios.add(new Usuario(nombre,contraseña, correo,rut, numero));
        }
        return usuarios;
    }


}
