/**
 * 
 */
package com.abcSchool.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class GenerarFacturaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idReserva = request.getParameter("idReserva"); 
		String tipo = request.getParameter("tipo");
		String medioPago=request.getParameter("medioPago"); 
		String remitente=request.getParameter("remitente"); 
		
		BusinessDelegate.getInstancia().generarFactura(idReserva,  tipo,  remitente,  medioPago);
		FacturaDTO factura=//FALTA METODO PARA BUSCAR LA FACTURA
		request.setAttribute("factura",factura);
		String jsp="/Factura.jsp"; //revisar nombre jsp
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
	}
}