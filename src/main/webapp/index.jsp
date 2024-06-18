<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Menu</title>
</head>
<body>
<h1 class="encabezado">Menu principal</h1>
<br/>
<form action="registroUsuario" method="get">
  <div class="centrado">
    <input type="submit" value="Registrar Usuario" class="boton">
  </div>
</form>

<form action="ingresoUsuario" method="get">
  <div class="centrado">
    <input type="submit" value="Ingresar Usuario" class="boton">
  </div>
</form>

<form action="mostrarUsuarios" method="get">
  <div class="centrado">
    <input type="submit" value="Mostrar Usuarios" class="boton">
  </div>
</form>

</body>
</html>