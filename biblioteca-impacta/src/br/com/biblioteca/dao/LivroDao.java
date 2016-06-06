package br.com.biblioteca.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.modelo.Livro;

public class LivroDao {
	private static LivroDao instance;
	
	protected EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
		if (entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	public LivroDao(){
		entityManager = getEntityManager();
	}
	
	public void adiciona(Livro livro) {
		entityManager.getTransaction().begin();
		entityManager.persist(livro);
		entityManager.getTransaction().commit();
	}
	
	public void alterar(Livro livro) {
		entityManager.getTransaction().begin();
		entityManager.merge(livro);
		entityManager.getTransaction().commit();
	}
	
	public List<Livro> getList(){
		Query query = entityManager.createQuery("select l from Livro as l");
		return  query.getResultList();
	}
	
	public Livro CarregaLivro(long id) {
	    return entityManager.find(Livro.class, id);
	}
	
	public void AlterarLivro(Long id){
		
	}
	
	public List<Livro> localzarLivros(String campo, String valor){
		String queryCommand = "select l from Livro as l where "+campo+"='"+valor+"'";
		Query query = entityManager.createQuery(queryCommand);
		return  query.getResultList();
	}
}
