package ar.com.users.controllers;

import ar.com.users.bo.PersonaBO;
import ar.com.users.bo.impl.PersonaBOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/listar")
public class Listar extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonaBO bo = new PersonaBOImpl();

		request.setAttribute("users", bo.getAll());

		RequestDispatcher miDisp = request.getRequestDispatcher("/listar.jsp");
		miDisp.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
