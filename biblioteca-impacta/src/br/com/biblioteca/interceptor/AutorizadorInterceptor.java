package br.com.biblioteca.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		HttpSession session = request.getSession();

		// Criar o metodo usuario logado
		if (session.getAttribute("usuarioLogado") != null) {
			return true;
		}

		String uri = request.getRequestURI();
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin")
		/*
		 * Após criar a pasta resources e colocar as imagens, css, e JavaScript
		 * descomentar o seguinte trecho: --|| uri.contains("resources"--)
		 */) {
			return true;
		}

		response.sendRedirect("loginForm");
		return false;
	}
}
