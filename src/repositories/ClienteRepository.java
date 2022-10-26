package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
		// abrir conexão com o banco de dados
		Connection  connection = ConnectionFactory.createConnection();
		
		// escrever um comando sql para ser executado no BD
		PreparedStatement statement = connection.prepareStatement("update cliente set nome=?, email=?, telefone=? where idCliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setInt(4, cliente.getIdCliente());
		statement.execute();
		
		
		// fechando a conexão
		connection.close();
		
				
	}

	// método para excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {
		
		// abrir conexão com banco de dados
		Connection connection = ConnectionFactory.createConnection();
		
		// escrever um comando SQL para executar no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from cliente where idclient=?");
		statement.setInt (1, cliente.getIdCliente());
		statement.execute();
		
		// fechando a conexão com banco de dados
		connection.close();
		
	}

	// método para consultar todos os clientes no banco de dados
	public List<Cliente> findAll() throws Exception {
		
		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();
		
		// escrever um comando SQL para executar no banco de dados
		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();
		
		// criando uma lista de clientes vazia
		List<Cliente> lista = new ArrayList<Cliente>();
		
		// percorrer cada registro contido no ResultSet
		while(resultSet.next()) {
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			
			lista.add(cliente); // adicionando cada cliente dentro da lista
		}
		
		connection.close();  // fechando a conexão
		return lista;  // retornando a lista clientes
		
	}

	// método para consultar 1 cliente no banco de dados atraves do id
	public Cliente findById(Integer idCliente) throws Exception {
		
		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();
		
		// escrever um comando SQL para executar no banco de dados
		PreparedStatement statement = connection.prepareStatement("select * from cliente where idcliente=?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();
		
		Cliente cliente = null;
		
		// se algum cliente foi encontrado
		if(resultSet.next()) {
			
			cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
		}
		
		connection.close();
		return cliente;
		
	}
}
