package ar.com.users.controllers;

import ar.com.users.bean.Persona;
import ar.com.users.bo.PersonaBO;
import ar.com.users.bo.impl.PersonaBOImpl;
import ar.com.users.exceptions.DNIDuplicateBOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class Insertar extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonaBO bo = new PersonaBOImpl();

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");

		Persona p = Persona.builder()
				.nombre(nombre)
				.apellido(apellido)
				.dni(Integer.parseInt(dni))
				.build();

		try {
			bo.save(p);
		} catch (DNIDuplicateBOException e) {
			throw new RuntimeException(e);
		}

		response.sendRedirect(request.getContextPath() + "/listar");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
