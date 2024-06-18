<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Ingreso Usuario</title>
</head>
<body>
<h1 class="encabezado">Ingreso de usuarios</h1>
<form action="ingresoUsuario" method="post">
    <div class="centrado">
        <label>Correo:</label>
        <input type="text" name="correo" class="campoTexto">
        <br>
        <label>Contraseña:</label>
        <input type="text" name="contraseña" class="campoTexto">


        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
</body>
</html>