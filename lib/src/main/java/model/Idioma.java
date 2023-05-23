package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "IDIOMA")
public class Idioma{
	@Id
	private int codigo;
	private String nome;
	
	@ManyToMany(mappedBy = "audios")
	private List<Unidade> unidadesAudio;
	@ManyToMany(mappedBy = "legendas")
	private List<Unidade> unidadesLegenda;

	public Idioma() {
		//Para o Hibernate
	}
	
	public Idioma(int codigo, String nome, List<Unidade> unidadesAudio, List<Unidade> unidadesLegenda) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.unidadesAudio = unidadesAudio;
		this.unidadesLegenda = unidadesLegenda;
	}

	public List<Unidade> getUnidadesAudio() {
		return unidadesAudio;
	}

	public void setUnidadesAudio(List<Unidade> unidadesAudio) {
		this.unidadesAudio = unidadesAudio;
	}

	public List<Unidade> getUnidadesLegenda() {
		return unidadesLegenda;
	}

	public void setUnidadesLegenda(List<Unidade> unidadesLegenda) {
		this.unidadesLegenda = unidadesLegenda;
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
