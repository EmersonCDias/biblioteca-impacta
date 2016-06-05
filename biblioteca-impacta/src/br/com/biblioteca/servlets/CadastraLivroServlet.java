package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.modelo.Livro;

/**
 * Servlet implementation class CadastraLivroServlet
 */
@WebServlet("/cadastrarLivro(removido)")
public class CadastraLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastraLivroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro();
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setStatus("DISPONIVEL");
		LivroDao dao = new LivroDao();
		dao.adiciona(livro);
		System.out.println("CADASTRADO");
		request.getRequestDispatcher("menu.html").forward(request, response);
	}

}

/*package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.dao.UsuarioDao;
import br.com.biblioteca.modelo.Usuario;

*//**
 * Servlet implementation class CadastraLivroServlet
 *//*
@WebServlet("/cadastrarUsuario")
public class CadastraUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#HttpServlet()
	 *//*
	public CadastraUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	*//**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setTipo(request.getParameter("tipo"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		System.out.println("CADASTRADO");
		request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
*/