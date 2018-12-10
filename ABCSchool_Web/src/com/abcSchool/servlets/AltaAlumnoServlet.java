package com.abcSchool.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String domicilio = request.getParameter("domicilio");
		String mail=request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		String fechaNac = request.getParameter("fechaNac"); // pasar a date sql
		String pswd = request.getParameter("pass");
		String pswdConf=request.getParameter("passConf");
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate_FechaNac= df.parse(fechaNac);
		java.sql.Date sqlDate_fechaNac=new java.sql.Date(utilDate_FechaNac.getTime());
		String jsp;
		if(pswd==pswdConf) {
			//chequear como llamar bien al bd.
			BusinessDelegate.getInstancia().altaAlumno(dni, nombre, mail, telefono, domicilio, sqlDate_fechaNac, pswd);
			jsp="/DatosCorrectos.jsp"; //EJEMPLO; CAMBIAR POR EL NOMBRE DEL JSP QUE VA!!;
		}
		else {
			jsp="//pendiente";//EJEMPLO; CAMBIAR POR EL NOMBRE DEL JSP QUE VA!!;
		}
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
		//metodo altaAlumno del Delegate, que devuelva boolean para verificar el alta del alumno
	}
	

}
