package br.com.biblioteca.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.biblioteca.dao.UsuarioDao;
import br.com.biblioteca.modelo.Usuario;

@Controller
public class LoginController {
	@RequestMapping("/loginForm")
	public String formulario() {
		return "usuario/login";
	}

	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		UsuarioDao dao = new UsuarioDao();
		
		Usuario user = dao.carregaDados(usuario);
		String tipo = user.getTipo();
		if(user!= null){
			System.out.println("Não é Nulo!");
		}
		if(user.getTipo().equals("bibliotecario")){
			System.out.println("é bibliotecario");
		}

		System.out.println(user.getTipo());
		if (user != null && user.getTipo().equals("bibliotecario")) {

			session.setAttribute("usuarioLogado", usuario);

			return "sucesso/bem-vindo";
		}
		if(user != null &&  !user.getTipo().equals("bibliotecario")) {
			session.setAttribute("usuarioLogado", usuario);
			return "sucesso/bem-vindo2";
		
		}
		return "erro/login-erro";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
