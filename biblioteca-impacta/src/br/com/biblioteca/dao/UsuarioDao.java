package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.modelo.Usuario;

public class UsuarioDao {
	private static Usuario instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("biblioteca");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public UsuarioDao() {
		entityManager = getEntityManager();
	}

	public void adiciona(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}

	public void alterar(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
	}

	public void remove(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
	}

	public List<Usuario> getList() {
		Query query = entityManager.createQuery("select u from Usuario as u");
		return query.getResultList();
	}

	public Usuario carregaUsuario(long id) {
		return entityManager.find(Usuario.class, id);
	}

	public Usuario carregaDados(Usuario usuario) {
		String login= usuario.getLogin();
				
		try {
			
			return (Usuario) entityManager
					.createQuery(
							"select u from Usuario u where"
							+ " u.login = :login").
				setParameter("login", login).getSingleResult();
			

		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario getUsuario(Usuario usuario) {
		String login = usuario.getLogin();
		String senha = usuario.getSenha();

		try {

			entityManager
					.createQuery(
							"select u from Usuario u where"
									+ " u.login = :login and u.senha = :senha")
					.setParameter("login", login).setParameter("senha", senha);

			return usuario;
		} catch (NoResultException e) {
			return null;
		}

	}

	/*
	 * public String verificaAcesso(Usuario usuario) { String tipo =
	 * usuario.getTipo(); tipo.charAt(0); switch (tipo) { case "b": return
	 * "bibliotecario"; case "p": return "professor"; case "a": return "aluno";
	 * default: return null; } };
	 */

}