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
	
	public RegistroEmprestimo CarregaReg(long id) {
	    return entityManager.find(RegistroEmprestimo.class, id);
	}
	
	public void AlterarReg(RegistroEmprestimo reg){
		entityManager.getTransaction().begin();
		entityManager.merge(reg);
		entityManager.getTransaction().commit();
	}
	
	public RegistroEmprestimo CarregaRegIdLivro(long idLivro){
		Query query = entityManager.createQuery("select l from RegistroEmprestimo as l where idLivro='"+idLivro+"'");
		List<RegistroEmprestimo> re = query.getResultList();
		return re.get(0);
	}
	public void atualizaPendentes(){
		entityManager.getTransaction().begin();
		String update = "UPDATE RegistroEmprestimo r SET r.status='CANCELADO' where r.status='PENDENTE'";
		//update Roleuser r set r.firstName = 'Jignesh I' where r.userID=9
		Query query = entityManager.createQuery(update);
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
}
