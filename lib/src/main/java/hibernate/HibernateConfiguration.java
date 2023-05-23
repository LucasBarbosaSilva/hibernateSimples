 package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Blueray;
import model.Cliente;
import model.DVD;
import model.Filme;
import model.Idioma;
import model.Locacao;
import model.Unidade;


public class HibernateConfiguration {

	private Configuration cfg;
	private SessionFactory factory;

	public HibernateConfiguration(){
		cfg = new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:33061/locadora2");
		cfg.setProperty("hibernate.connection.username", "root"); 
		cfg.setProperty("hibernate.connection.password", "1234");

       //opcionais - INICIO
		cfg.setProperty("hibernate.connection.characterEncoding", "utf8");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update"); //Se houver alguma incompatibilidade entre tabela e classe, o hibernate se vira pra resolver.
		cfg.setProperty("hibernate.connection.autoReconnect", "true"); //Se houver queda em execução, a idiea é que ele tente reconectar
		cfg.setProperty("hibernate.show_sql", "true"); //antes de executar o comando, ele printa o comando sql
         //opcionais - FIM

		//Classes persistentes - inicio
		cfg.addAnnotatedClass(Cliente.class);
		cfg.addAnnotatedClass(Filme.class);
		cfg.addAnnotatedClass(Idioma.class);
		cfg.addAnnotatedClass(Unidade.class);
		cfg.addAnnotatedClass(DVD.class);
		cfg.addAnnotatedClass(Blueray.class);
		cfg.addAnnotatedClass(Locacao.class);
		//Classes persistentes - fim
		
	    ServiceRegistry serviceRegistry = 
      new StandardServiceRegistryBuilder().applySettings(this.cfg.getProperties()).build();
	    factory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	
	public Session getSession() {
        //Retorna a sessão aberta
    	return this.factory.openSession();
    }
    
    public Configuration getConfiguration() {
        //Retorna a configuracao
    	return this.cfg;
    }
}
