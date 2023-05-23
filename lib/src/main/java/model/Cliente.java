package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	private String login;
	private String nome;
	@OneToMany(mappedBy = "cliente") 
	//posso utilizar o fetch = Lazy, isso faz com que, nossas requisições fiquem mais leves. Executa sobre demanda.
	//Precisa que a mesma conexão ainda esteja aberta
	private List<Locacao> locacoes;

	
	public Cliente() {
		//Para o Hibernate
	}
	
	public Cliente(String login, String nome) {
		super();
		this.login = login;
		this.nome = nome;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.login + " - " + this.nome;
	}

}