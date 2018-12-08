package servlets;

import java.io.IOException;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String user=request.getParameter("CUIT");
		String passhash=request.getParameter("password");
		String type=request.getParameter("type");
		try {
			if(type.equals("0")){
				boolean log = BusinessDelegate.getInstancia().loginCliente(Integer.parseInt(user), passhash);
				if(log) {
					ClienteDTO cliente=BusinessDelegate.getInstancia().obtenerCliente(Integer.parseInt(user));
					request.getSession().setAttribute("cliente", cliente);
					request.setAttribute("cliente", cliente);
					RequestDispatcher rd = request.getRequestDispatcher("VistaCliente.jsp");
				    rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				    rd.forward(request, response);
				}
			}
			if(type.equals("1")){
				int log = BusinessDelegate.getInstancia().loginEmpleado(Integer.parseInt(user), passhash);
				if(log==-1) {
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				    rd.forward(request, response);
				}else {
					if(log==0) {
						//Ventas
						RequestDispatcher rd = request.getRequestDispatcher("VistaAdmin.jsp");
					    rd.forward(request, response);
					}else {
						if(log==1) {
							//Compras
							RequestDispatcher rd = request.getRequestDispatcher("VistaAdminCompras.jsp");
						    rd.forward(request, response);
						}
					}
				}
			}
		}catch (CommunicationException e) {
			e.printStackTrace();
		}
	}

}

