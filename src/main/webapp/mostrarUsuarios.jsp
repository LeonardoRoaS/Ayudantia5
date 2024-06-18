<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 17-06-2024
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Mostrar Usuarios</title>
</head>
<body>
<h1 class="encabezado">Usuarios ingresados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>Nombre usuario</th>
            <th>Correo</th>
            <th>Numero</th>
        </tr>
        <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td><c:out value="${usuario.getNombre()}"></c:out> </td>
                <td> <c:out value="${usuario.getCorreo()}"></c:out> </td>
                <td> <c:out value="${usuario.getNumero()}"></c:out> </td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
