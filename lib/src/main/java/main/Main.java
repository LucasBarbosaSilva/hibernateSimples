package main;

import org.hibernate.Session;

import hibernate.HibernateConfiguration;
import model.Cliente;
import model.Locacao;
import persistencia.DAOCliente;
import persistencia.IDAOCliente;

public class Main {
	public static void mainOLD(String[] args) {
		HibernateConfiguration hbCfg = new HibernateConfiguration();
		
		Session hbSession = hbCfg.getSession();
		Cliente c1 = hbSession.get(Cliente.class, "phsb");
		System.out.println(c1);
		for(Locacao l : c1.getLocacoes()) {
			System.out.println(l);
		}
	}
	
	public static void main(String[] args) {
		IDAOCliente daoCliente = new DAOCliente();
		
		Cliente cCadu = new Cliente("cadu", "Carlos Edu");
		daoCliente.adicionarOuAlterarCliente(cCadu);
		cCadu = daoCliente.getCliente("cadu");
		System.out.println(cCadu);
		daoCliente.apagarCliente(cCadu);
		cCadu = daoCliente.getCliente("cadu");
		System.out.println(cCadu);
	}
}
