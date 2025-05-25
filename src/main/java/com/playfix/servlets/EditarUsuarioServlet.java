package com.playfix.servlets;

import com.playfix.model.Usuario;
import com.playfix.utils.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/editar_usuario")
public class EditarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect("HelloServlet");
            return;
        }

        int id = Integer.parseInt(idParam);

        try (Connection conn = ConexionDB.obtenerConexion()) {
            String sql = "SELECT id_usuario, nombre_usuario, mail_usuario, telefono_usuario FROM tabla_usuarios WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("mail_usuario"),
                        rs.getString("telefono_usuario")
                );
                req.setAttribute("usuario", usuario);
                req.getRequestDispatcher("/editar_usuario.jsp").forward(req, resp);
            } else {
                // Si no se encuentra usuario, redirigir a lista
                resp.sendRedirect("HelloServlet");
            }
        } catch (SQLException e) {
            throw new ServletException("Error al obtener usuario para edición", e);
        }
    }



}
