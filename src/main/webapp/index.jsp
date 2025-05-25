<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="com.playfix.model.Usuario" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hola desde JSP</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<div class="container">
    <h1>Usuarios</h1>

    <a href="nuevo_usuario.jsp" class="btn btn-primary mb-3">Agregar Usuario</a>

    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        if (usuarios != null && !usuarios.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% for (Usuario u : usuarios) { %>
            <tr>
                <td><%= u.getIdUsuario() %></td>
                <td><%= u.getNombreUsuario() %></td>
                <td><%= u.getMailUsuario() %></td>
                <td><%= u.getTelefonoUsuario() %></td>
                <td>
                    <a href="editar_usuario?id=<%= u.getIdUsuario() %>" class="btn btn-warning">Editar</a>
                    <a href="eliminar_usuario?id=<%= u.getIdUsuario() %>" class="btn btn-danger"
                       onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
        <p>No hay usuarios registrados.</p>
    <% } %>
  </div>
</body>
</html>