package com.playfix.servlets;

import com.playfix.model.Usuario;
import com.playfix.utils.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String mensaje;

        try (Connection conn = ConexionDB.obtenerConexion()) {
            if (conn != null) {
                mensaje = "Conexión exitosa a PostgreSQL";
            } else {
                mensaje = "No se pudo establecer conexión";
            }
        } catch (SQLException e) {
            mensaje = "Error de conexión: " + e.getMessage();
        }

        req.setAttribute("mensajeConexion", mensaje);


        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Usuario> listaUsuarios = new ArrayList<>();

        try (Connection conn = ConexionDB.obtenerConexion()) {
            String sql = "SELECT id_usuario, nombre_usuario, mail_usuario, telefono_usuario FROM tabla_usuarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre_usuario");
                String mail = rs.getString("mail_usuario");
                String telefono = rs.getString("telefono_usuario");

                Usuario usuario = new Usuario(id, nombre, mail, telefono);
                listaUsuarios.add(usuario);
            }

            req.setAttribute("usuarios", listaUsuarios);

        } catch (SQLException e) {
            req.setAttribute("mensajeConexion", "Error: " + e.getMessage());
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);


    }

}
