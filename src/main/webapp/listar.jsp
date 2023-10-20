<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<!DOCTYPE html>
<html>
<%@ include file="static/header.htm" %>
<body>

	<h1>TABLA USUARIOS</h1>

	<div id="contenedor-boton">
		<input type="button" value="Insertar Usuario" onclick="window.location.href='add.jsp'"/>
	</div>

	<table border="1" frame="void" rules="rows">
	
		<tr>
			<td class="cabecera">NOMBRE</td>
			<td class="cabecera">APELLIDO</td>
			<td class="cabecera">DNI</td>
			<td class="cabecera" colspan="2">ACCION</td>
		</tr>
		
		<c:forEach var="u" items="${users}">

            <c:url var="urlUpdate" value="/update">
                <c:param name="dni" value="${u.dni}"></c:param>
            </c:url>
            <c:url var="urlDelete" value="/delete">
                <c:param name="dni" value="${u.dni}"></c:param>
            </c:url>

			<tr class="filas">
				<td class="celdas">${u.nombre}</td>
				<td class="celdas">${u.apellido}</td>
				<td class="celdas">${u.dni}</td>
                <td class="celdas">
                    <input type="button" value="Modificar" onclick="window.location.href='${urlUpdate}'"/>
                </td>
                <td class="celdas">
                    <input type="button" value="Borrar" onclick="window.location.href='${urlDelete}'"/>
                </td>
			</tr>
			
		</c:forEach>		
	
	</table>	

</body>
</html>