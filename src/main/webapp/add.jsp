<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="static/header.htm" %>
<body>

	<h1>Inserta nuevo usuario</h1>
	
	<form method="post" action="<c:url value="/add" />"">
		<table>
			
		<tr>
		<td><label for="nombre">NOMBRE</label></td>
		<td><input type="text" id="nombre" name="nombre" maxlength="255"></td>
		</tr>
		
		<tr>
		<td><label for="apellido">APELLIDO</label></td>
		<td><input type="text" id="apellido" name="apellido" maxlength="255"></td>
		</tr>
		
		<tr>
		<td><label for="dni">DNI</label></td>
		<td><input type="text" id="dni" name="dni" maxlength="255"></td>
		</tr>

		</table>

        <div id="contenedor-boton">
            <c:url value="/listar" var="redirectUrl"/>

            <input type="button" value="Volver" onclick="window.location.href='${redirectUrl}'"/>
            <input type="submit" name="submit" value="Enviar">
        </div>

		
	</form>

</body>
</html>