package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// método estático
	public static Connection createConnection() throws Exception {

		// Informar o DRIVER de conexão do postgresql
		Class.forName("org.postgresql.Driver");

		// abrir e retornar a conexão com o banco de dados
		return DriverManager.getConnection("jdbc://postgresql:localhost:5432/bd_aula04", "postgres", "coti");
	}
}
