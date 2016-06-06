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
//			Usuario usuario2 = new Usuario();
//			usuario2.setLogin("max");
//			usuario2.setSenha("123");
//			usuario2.setNome("Maxwel");
//			usuario2.setTipo("bibliotecario");
//			dao.adiciona(usuario2);
		if (dao.getUsuario(usuario) != null ) {
			session.setAttribute("usuarioLogado", usuario);

			return "sucesso/bem-vindo";

		}
		return "erro/login-erro";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
