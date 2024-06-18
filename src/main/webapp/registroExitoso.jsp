<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 17-06-2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro Exitoso</title>
</head>
<body>
<h1 class="encabezado"> Registro de usuarios</h1>
<div class="centrado">
    <p class="subtitulo">Registro exitoso</p> <br>
    <label class="campoTexto"> Usuario : <c:out value="${usuario.getNombre()}"></c:out> </label>
    <br>
    <label class="campoTexto">Correo : <c:out value="${usuario.getCorreo()}"></c:out></label>
    <br>
    <label class="campoTexto">Número Contacto : +<c:out value="${usuario.getNumero()}"></c:out></label>
    <br>
    <label class="campoTexto">Rut : <c:out value="${usuario.getRut()}"></c:out></label>
    <br>
    <a class="boton" href="ingresoUsuario">Ingresar</a>
</div>

</body>
</html>
