package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.dao.RegistroEmprestimoDao;
import br.com.biblioteca.modelo.Livro;
import br.com.biblioteca.modelo.RegistroEmprestimo;

/**
 * Servlet implementation class CadastraLivroServlet
 */
@WebServlet("/registroEmprestimo")
public class CadastrarRegistroEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarRegistroEmprestimo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistroEmprestimo re = new RegistroEmprestimo();
		RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
		LivroDao livroDao = new LivroDao();
		
		re.setNome(request.getParameter("nome"));
		re.setRa(request.getParameter("ra"));
		//re.setIdLivro(request.getParameter("idLivro"));
		re.setDataEntrega(request.getParameter("retirada"));
		re.setDataEntrega(request.getParameter("devolucao"));
		
		Livro livro = livroDao.CarregaLivro(Long.parseLong(request.getParameter("idLivro")));
		
		if (livro.getStatus().equalsIgnoreCase("DISPONIVEL")){
			livro.setStatus("EMPRESTADO");
			livroDao.alterar(livro);
			reDao.adiciona(re);
			System.out.println("REGISTRADO");
		}else {
			System.out.println("LIVRO NÃO DISPONIVEL PARA EMPRESIMO");
		}
		request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
