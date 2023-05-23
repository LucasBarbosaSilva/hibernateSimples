package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "FILME")
public class Filme {
	@Id
	private int codigo;
	private String nome;
	@OneToMany(mappedBy = "filme")
	private List<Unidade> unidades;
	
	
	public Filme() {
		//Para o Hibernate
	}
	
	public Filme(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.nome;
	}

}
