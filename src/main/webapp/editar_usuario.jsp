<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.playfix.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<div class="container">
    <h2>Editar Usuario</h2>

    <%
        Usuario usuario = (Usuario) request.getAttribute("usuario");
        if (usuario == null) {
    %>
        <p>Usuario no encontrado.</p>
    <%
        } else {
    %>
    <form action="actualizar_usuario" method="post">
        <!-- Campo oculto para el ID -->
        <input type="hidden" name="id" value="<%= usuario.getIdUsuario() %>">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= usuario.getNombreUsuario() %>" required><br>

        <label>Email:</label>
        <input type="email" name="mail" value="<%= usuario.getMailUsuario() %>" required><br>

        <label>Teléfono:</label>
        <input type="text" name="telefono" value="<%= usuario.getTelefonoUsuario() %>" required><br>

        <button type="submit">Actualizar</button>
    </form>
    <%
        }
    %>

    <br>
    <a href="HelloServlet">Volver a la lista</a>
</div>
</body>
</html>