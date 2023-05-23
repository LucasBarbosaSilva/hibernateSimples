package persistencia;

import java.util.List;

import model.Cliente;

public interface IDAOCliente {

	Cliente getCliente(String login);
	List<Cliente> getClientes();
	void adicionarOuAlterarCliente(Cliente c);
	List<Cliente> getClientes(String filtroNome);
	void apagarCliente(Cliente c);
}