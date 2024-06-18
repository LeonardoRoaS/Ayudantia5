<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro Usuario</title>
</head>
<body>
<h1 class="encabezado">Registro de usuarios</h1>
<h2 class="subtitulo">Datos incorrectos, favor comprobar nuevamente</h2>
<form action="registroUsuario" method="post">
    <div class="centrado">
        <label>Nombre Completo:</label>
        <input type="text" name="nombre" class="campoTexto">
        <br>
        <label>Contraseña:</label>
        <input type="text" name="contraseña" class="campoTexto">
        <br>
        <label>Correo:</label>
        <input type="text" name="correo" class="campoTexto">
        <br>
        <label>Número contacto:</label>
        <input type="text" name="numero" class="campoTexto">
        <br>
        <label>RUT:</label>
        <input type="text" name="rut" class="campoTexto">



        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
</body>
</html>