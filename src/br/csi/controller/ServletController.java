package br.csi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Equals;

import br.csi.model.Usuario;
import br.csi.model.dao.UsuarioDAO;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("Login");
		String senha = request.getParameter("senha");
		
		String opcao = request.getParameter("opcao");
		
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);

		UsuarioDAO uD = new UsuarioDAO();
		RequestDispatcher dispatcher;
		
		if(opcao equals("cadastro")){
			String pagina = "/WEB-INF/jsp/cadastro.jsp";
			dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);			
		}

		try {
			
			boolean retorno = uD.autenticado(u);
			if(retorno){
				String pagina = "/WEB-INF/jsp/principal.jsp";
				request.setAttribute("usuario", u);
				dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
				
			}else{
				String pagina = "/index.jsp";
				request.setAttribute("msg", "Login ou senha invalidos");
				dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			String pagina = "/index.jsp";
			dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
