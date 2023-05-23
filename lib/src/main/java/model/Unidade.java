package model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "UNIDADE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue Só seria preciso se fosse concreta
public abstract class Unidade {
	@Id
	private int codigo;
	private double preco;
	@OneToMany(mappedBy = "unidade")
	private List<Locacao> locacoes;
	@ManyToMany
	@JoinTable(
		name = "POSSUIR_AUDIO", 
		joinColumns = {@JoinColumn(name="CODIGO_UNIDADEFK", referencedColumnName = "codigo")},
		inverseJoinColumns = { @JoinColumn(name="CODIGO_IDIOMAFK", referencedColumnName = "codigo")}
	)
	private List<Idioma> audios;
	@ManyToMany
	@JoinTable(
		name = "POSSUIR_LEGENDA", 
		joinColumns = {@JoinColumn(name="CODIGO_UNIDADEFK", referencedColumnName = "codigo")},
		inverseJoinColumns = { @JoinColumn(name="CODIGO_IDIOMAFK", referencedColumnName = "codigo")}
	)
	private List<Idioma> legendas;
	@ManyToOne
	@JoinColumn(name="CODIGO_FILMEFK", referencedColumnName = "CODIGO")
	private Filme filme;
	
	
	public Unidade() {
		//Para o Hibernate
	}
	
	public Unidade(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}
	

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Idioma> getAudios() {
		return audios;
	}

	public void setAudios(List<Idioma> idiomas) {
		this.audios = idiomas;
	}

	public List<Idioma> getLegendas() {
		return legendas;
	}

	public void setLegendas(List<Idioma> idiomas) {
		this.legendas = idiomas;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return this.filme + "(R$ " + this.preco + ")";
	}

}
