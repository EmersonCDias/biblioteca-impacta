package br.com.biblioteca.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.dao.RegistroEmprestimoDao;
import br.com.biblioteca.modelo.Livro;
import br.com.biblioteca.modelo.RegistroEmprestimo;

@Controller
public class BibliotecaController {
	@RequestMapping("menu.html")
	public String teste(){
		return "sucesso/cadastrado";
	}
	@RequestMapping("cadastrarLivro")
	public String cadastrarLivro(@ Valid Livro livro, BindingResult result){
		if(result.hasFieldErrors("nome")||result.hasFieldErrors("autor")) {
			return "erro/nao-cadastrado";
		} 
		LivroDao dao = new LivroDao();
		livro.setStatus("DISPONIVEL");
		dao.adiciona(livro);
		return "sucesso/cadastrado";
	}
	
	@RequestMapping("listaLivros")
	  public String lista(Model model) {
	    LivroDao dao = new LivroDao();
	    model.addAttribute("livro", dao.getList());
	    return "livro/lista";
	  }
	@RequestMapping("localizaLivro")
	public String localizaLivro(Long id,Model model){
		LivroDao dao = new LivroDao();
	    model.addAttribute("livroLocalizado", dao.CarregaLivro(id));
	    return "livro/livro-localizado";
	}
	
	@RequestMapping("emprestaLivro")
	public String emprestaLivro(Livro livro,Model model){
		RegistroEmprestimo re = new RegistroEmprestimo();
//		RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
//		reDao.adiciona(re);
		re.setIdLivro(livro.getId());
		model.addAttribute("registroEmprestimo", re);
		return "livro/emprestaLivroUsuario";
	}
	@RequestMapping("concluirEmprestimo")
	public String concluirEmprestimo(RegistroEmprestimo re){
		RegistroEmprestimoDao reDao = new RegistroEmprestimoDao();
		reDao.adiciona(re);
		return "sucesso/emprestimo-concluido";
	}
	/*
  @RequestMapping("novaTarefa")
  public String form() {
    return "tarefa/formulario";
  }	

  @RequestMapping("adicionaTarefa")
  public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
    System.out.println("teste");
    if(result.hasFieldErrors("descricao")) {
      return "tarefa/formulario";
    }    

    TarefaDao dao = new TarefaDao();
    dao.adiciona(tarefa);
    return "tarefa/adicionada";
  }
  
  @RequestMapping("listaTarefas")
  public String lista(Model model) {
    TarefaDao dao = new TarefaDao();
    model.addAttribute("tarefas", dao.list());
    return "tarefa/lista";
  }
  
  @RequestMapping("removeTarefa")
  public String remove(Tarefa tarefa) {
    TarefaDao dao = new TarefaDao();
    dao.remover(tarefa);
    return "redirect:listaTarefas";
  }

  @RequestMapping("mostraTarefa")
  public String mostra(Long id, Model model) {
    TarefaDao dao = new TarefaDao();
    model.addAttribute("tarefa", dao.buscaPorId(id));
    return "tarefa/mostra";
  }
  
  @RequestMapping("alteraTarefa")
  public String altera(Tarefa tarefa) {
    TarefaDao dao = new TarefaDao();
    dao.alterar(tarefa);
    return "redirect:listaTarefas";
  }
*/}
