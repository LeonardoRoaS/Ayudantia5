<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Perfil</title>
</head>
<body>
<h1 class="encabezado">Perfil</h1>
<h2 class="subtitulo">Informacion:</h2>
<form action="perfilUsuario" method="post">
    <div class="centrado">
        <br>
        <label class="campoTexto"> Nombre Completo : <c:out value="${usuario.getNombre()}"></c:out> </label>
        <br>
        <label class="campoTexto">Correo : <c:out value="${usuario.getCorreo()}"></c:out></label>
        <br>
        <label class="campoTexto">Rut : <c:out value="${usuario.getRut()}"></c:out></label>
        <br>
        <label class="campoTexto">Número Contacto : +<c:out value="${usuario.getNumero()}"></c:out></label>



        <br><br>
        <a class="boton" href="index.jsp">Volver</a>

    </div>
</form>
</body>
</html>