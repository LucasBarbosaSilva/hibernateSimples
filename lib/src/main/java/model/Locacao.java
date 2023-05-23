package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOCAR")
public class Locacao implements Serializable{
	private static final long serialVersionUID = 5174951714913676812L;
	@Id
	private Date data_locacao;
	private Date data_devolucao;
	@Id
	@ManyToOne
	@JoinColumn(name = "LOGIN_CLIENTEFK", referencedColumnName = "LOGIN") //indica chave estrangeira
	private Cliente cliente;
	@Id
	@ManyToOne
	@JoinColumn(name = "CODIGO_UNIDADEFK", referencedColumnName = "CODIGO")
	private Unidade unidade;
	
	//GeneratedValue
	//Column(nullabe = false)
	
	public Locacao() {
		//Para o Hibernate
	}
	
	public Locacao(Date data_locacao, Date data_devolucao) {
		super();
		this.data_locacao = data_locacao;
		this.data_devolucao = data_devolucao;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Date getData_locacao() {
		return data_locacao;
	}

	public void setData_locacao(Date data_locacao) {
		this.data_locacao = data_locacao;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
		
		if(obj!=null  &&  obj instanceof Locacao) {
			if(this.cliente!=null && ((Locacao)obj).cliente!=null  &&  this.cliente.getLogin().equals(((Locacao)obj).cliente.getLogin())) {
				if(this.unidade!=null && ((Locacao)obj).unidade!=null  &&  this.unidade.getCodigo() == ((Locacao)obj).unidade.getCodigo()) {
					if(this.data_locacao!=null && ((Locacao)obj).data_locacao!=null  &&  this.data_locacao.equals(((Locacao)obj).data_locacao)) {
						out = true;
					}
				}
			}
		}
		
		return out;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + this.cliente.hashCode() - this.unidade.hashCode() + this.data_locacao.hashCode();
	}
	
	
	@Override
	public String toString() {
		return this.getData_locacao()+ " --> " + this.unidade;
	}

}