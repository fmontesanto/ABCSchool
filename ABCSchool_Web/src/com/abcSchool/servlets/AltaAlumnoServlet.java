package com.abcSchool.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

public class AltaAlumnoServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String domicilio = request.getParameter("nombre");
		String mail = request.getParameter("nombre");
		String telefono = request.getParameter("nombre");
		String fechaNac = request.getParameter("nombre");//Cambiar a Date!
		String pass = request.getParameter("nombre");
		String passConf = request.getParameter("nombre");
		
		BusinessDelegate.getInstancia().altaAlumno(dni, nombre, mail, telefono, domicilio, fechaNac, pass);
		//metodo altaAlumno del Delegate, que devuelva boolean para verificar el alta del alumno
	}
	

}
