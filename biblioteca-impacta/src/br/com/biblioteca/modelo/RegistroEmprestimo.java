package br.com.biblioteca.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class RegistroEmprestimo {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	private String ra;
	private String idLivro;
	private String dataRetirada;
	private String dataEntrega;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}
	public String getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
}
