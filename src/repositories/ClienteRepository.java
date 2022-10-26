package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// método para gravar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {

		// Abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrever um comando sql para ser executado no BD
		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email, telefone) values(?, ?, ?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.execute();

	}

	// método para atualizar um cliente no banco de dados
	public void update(Cliente cliente) throws Exception {
		// TODO
	}

	// método para excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {
		// TODO
	}

	// método para consultar todos os clientes no banco de dados
	public List<Cliente> findAll() throws Exception {
		// TODO
		return null;
	}

	// método para consultar 1 cliente no banco de dados atraves do id
	public Cliente findById(Integer idCliente) throws Exception {
		// TODO
		return null;
	}
}
