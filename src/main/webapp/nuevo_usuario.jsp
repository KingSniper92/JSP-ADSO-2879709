<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Usuario</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<div class="container">
    <h2>Agregar Nuevo Usuario</h2>
    <form action="guardar_usuario" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label>Email:</label>
        <input type="email" name="mail" required><br>

        <label>Teléfono:</label>
        <input type="text" name="telefono" required><br>

        <button type="submit">Guardar</button>
    </form>
    <br>
    <a href="HelloServlet">Volver a la lista</a>
</div>
</body>
</html>