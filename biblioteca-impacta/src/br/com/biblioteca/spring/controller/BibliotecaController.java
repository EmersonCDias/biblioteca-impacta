package br.com.biblioteca.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.dao.RegistroEmprestimoDao;
import br.com.biblioteca.dao.UsuarioDao;
import br.com.biblioteca.modelo.Livro;
import br.com.biblioteca.modelo.RegistroEmprestimo;
import br.com.biblioteca.modelo.Usuario;

@Controller
public class BibliotecaController {
	@RequestMapping("menu.html")
	public String teste() {
		return "sucesso/cadastrado";
	}

	@RequestMapping("cadastrarLivro")
	public String cadastrarLivro(@Valid Livro livro, BindingResult result) {
		if (result.hasFieldErrors("nome") || result.hasFieldErrors("autor")) {
			return "erro/nao-cadastrado";
		}
		LivroDao dao = new LivroDao();
		livro.setStatus("DISPONIVEL");
		dao.adiciona(livro);
		return "sucesso/cadastrado";
	}

	@RequestMapping("cadastrarUsuario")
	public String cadastrarUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasFieldErrors("nome") || result.hasFieldErrors("login")
				|| result.hasFieldErrors("senha")
				|| result.hasFieldErrors("tipo")) {
			return "erro/nao-cadastrado";
		}
		UsuarioDao dao = new UsuarioDao();
		// usuario.setStatus("DISPONIVEL");
		dao.adiciona(usuario);
		return "sucesso/cadastrado";
	}

	@RequestMapping("listaLivros")
	public String lista(Model model) {
		LivroDao dao = new LivroDao();
		model.addAttribute("livro", dao.getList());
		return "livro/lista";
	}
	
	@RequestMapping("listaUsuarios")
	public String listaUsuarios(Model model) {
		UsuarioDao dao = new UsuarioDao();
		model.addAttribute("usuario", dao.getList());
		return "usuario/lista-usuarios";
	}

	@RequestMapping("localizaLivro")
	public String localizaLivro(String tipo,String valor, Model model) {
		LivroDao dao = new LivroDao();
		List<Livro> listaLivrosLocalizados = dao.localzarLivros(tipo, valor);
		if (listaLivrosLocalizados != null){
			model.addAttribute("livroLocalizado", listaLivrosLocalizados);
			return "livro/livro-localizado";
		}
		return "erro/livro-nao-localizado";
	}
	
	@RequestMapping("localizaUsuario")
	public String localizaUsuario(Long id,String tipo,String valor, Model model) {
		UsuarioDao dao = new UsuarioDao();
		RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
		RegistroEmprestimo re = reDao.CarregaLivro(id);
		List<Usuario> listaUsuariosLocalizados = dao.localizarUsuario(tipo, valor);
		if (listaUsuariosLocalizados != null){
			model.addAttribute("usuario", listaUsuariosLocalizados);
			model.addAttribute("registroEmprestimo", re);
			return "usuario/usuario-localizado";
		}
		return "erro/usuario-nao-localizado";
	}
	@RequestMapping("emprestaLivro")
	public String emprestaLivro(long id, Model model) {
		LivroDao dao = new LivroDao();	
		Livro livro = dao.CarregaLivro(id);
		if (livro.getStatus().equalsIgnoreCase("disponivel")){
			RegistroEmprestimo re = new RegistroEmprestimo();
			RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
			re.setIdLivro(livro.getId());
			re.setStatus("PENDENTE");
			reDao.adiciona(re);
			model.addAttribute("registroEmprestimo", re);
			return "livro/emprestaLivroUsuario";
		}
		return "erro/livro-indisponivel";

	}
	@RequestMapping("formFinal")
	public String formFinal(Long idUser,Long idEmprestimo, Model model){
		UsuarioDao userDao =new UsuarioDao();
		Usuario user = userDao.carregaUsuario(idUser);
		RegistroEmprestimoDao regDao = new RegistroEmprestimoDao();
		RegistroEmprestimo reg = regDao.CarregaLivro(idEmprestimo);
		reg.setCpf(user.getCpf());
		reg.setNome(user.getNome());
		model.addAttribute("registroEmprestimo", reg);
		return "emprestimo/concluirEmprestimo";
	}

	@RequestMapping("concluirEmprestimo")
	public String concluirEmprestimo(RegistroEmprestimo re) {
		RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
		reDao.adiciona(re);
		return "sucesso/emprestimo-concluido";
	}

	

	/*
	 * @RequestMapping("novaTarefa") public String form() { return
	 * "tarefa/formulario"; }
	 * 
	 * @RequestMapping("adicionaTarefa") public String adiciona(@Valid Tarefa
	 * tarefa, BindingResult result) { System.out.println("teste");
	 * if(result.hasFieldErrors("descricao")) { return "tarefa/formulario"; }
	 * 
	 * TarefaDao dao = new TarefaDao(); dao.adiciona(tarefa); return
	 * "tarefa/adicionada"; }
	 * 
	 * @RequestMapping("listaTarefas") public String lista(Model model) {
	 * TarefaDao dao = new TarefaDao(); model.addAttribute("tarefas",
	 * dao.list()); return "tarefa/lista"; }
	 * 
	 * @RequestMapping("removeTarefa") public String remove(Tarefa tarefa) {
	 * TarefaDao dao = new TarefaDao(); dao.remover(tarefa); return
	 * "redirect:listaTarefas"; }
	 * 
	 * @RequestMapping("mostraTarefa") public String mostra(Long id, Model
	 * model) { TarefaDao dao = new TarefaDao(); model.addAttribute("tarefa",
	 * dao.buscaPorId(id)); return "tarefa/mostra"; }
	 * 
	 * @RequestMapping("alteraTarefa") public String altera(Tarefa tarefa) {
	 * TarefaDao dao = new TarefaDao(); dao.alterar(tarefa); return
	 * "redirect:listaTarefas"; }
	 */
}
