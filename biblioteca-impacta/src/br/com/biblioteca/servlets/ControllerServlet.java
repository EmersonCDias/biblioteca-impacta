package br.com.biblioteca.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response){
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.biblioteca.mvc.logica." + parametro;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			System.out.println("ERRO NA LOGICA");
		}
	}
}
