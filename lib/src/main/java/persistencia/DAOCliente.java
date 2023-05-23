package persistencia;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateConfiguration;
import model.Cliente;

public class DAOCliente implements IDAOCliente {
	private Session session;
	
	public DAOCliente() {
		HibernateConfiguration config = new HibernateConfiguration();
		this.session = config.getSession();
	}
	
	@Override
	public Cliente getCliente(String login) {
		 Cliente output = this.session.get(Cliente.class, login);
		 return output;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(){
		List<Cliente> output = null;
		String hql = "FROM Cliente c";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		return output;
	}
	
	@Override
	public void adicionarOuAlterarCliente(Cliente c) {
		Transaction t = this.session.beginTransaction(); //início da transação
		this.session.saveOrUpdate(c);
		t.commit(); //finalizando transação
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(String filtroNome){
		List<Cliente> output = null;
		String hql = "FROM Cliente c WHERE c.nome LIKE '%"+filtroNome+"%'";
		Query query = this.session.createQuery(hql);
		output = query.getResultList();
		return output;
	}
	
	@Override
	public void apagarCliente(Cliente c) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(c);
		t.commit();
	}
}
