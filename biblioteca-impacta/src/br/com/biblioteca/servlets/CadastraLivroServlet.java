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
@WebServlet("/cadastrarLivro")
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
