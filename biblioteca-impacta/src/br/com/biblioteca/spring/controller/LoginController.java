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
		if (dao.getUsuario(usuario) != null) {
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
