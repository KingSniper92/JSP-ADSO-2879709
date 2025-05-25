package com.playfix.servlets;

import com.playfix.utils.ConexionDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/guardar_usuario")
public class GuardarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String mail = req.getParameter("mail");
        String telefono = req.getParameter("telefono");

        String sql = "INSERT INTO tabla_usuarios (nombre_usuario, mail_usuario, telefono_usuario) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, mail);
            stmt.setString(3, telefono);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("HelloServlet");
    }
}