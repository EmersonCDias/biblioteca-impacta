package br.com.biblioteca.mvc.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.modelo.Livro;

public class CadastrarNovoLivro implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Livro livro = new Livro();
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setStatus("DISPONIVEL");
		LivroDao dao = new LivroDao();
		dao.adiciona(livro);
		System.out.println("CADASTRADO");
		return null;
	}

}
