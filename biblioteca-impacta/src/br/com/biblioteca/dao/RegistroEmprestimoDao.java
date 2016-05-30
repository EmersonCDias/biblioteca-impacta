package br.com.biblioteca.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.modelo.Livro;
import br.com.biblioteca.modelo.RegistroEmprestimo;

public class RegistroEmprestimoDao {
	private static RegistroEmprestimo instance;
	
	protected EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
		if (entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	public RegistroEmprestimoDao(){
		entityManager = getEntityManager();
	}
	
	public void adiciona(RegistroEmprestimo re) {
		entityManager.getTransaction().begin();
		entityManager.persist(re);
		entityManager.getTransaction().commit();
	}
	
	public List<RegistroEmprestimo> getList(){
		Query query = entityManager.createQuery("select l from RegistroEmprestimo as l");
		return  query.getResultList();
	}
	
	public RegistroEmprestimo CarregaLivro(long id) {
	    return entityManager.find(RegistroEmprestimo.class, id);
	}
	
	public void AlterarLivro(Long id){
		
	}
}
