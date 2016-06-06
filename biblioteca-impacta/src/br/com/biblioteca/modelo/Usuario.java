package br.com.biblioteca.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String login;
	private String senha;
	private String nome;
	private String tipo;
	private String cpf;
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public Usuario setTipo(String tipo) {
		this.tipo = tipo;
		
		return this;
	}

	public long getId() {
		return id;
	}

	public Usuario setId(long id) {
		this.id = id;
		
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Usuario setNome(String nome) {
		this.nome = nome;
		
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Usuario setLogin(String login) {
		this.login = login;
		
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		
		return this;
	}
	 
	
}
