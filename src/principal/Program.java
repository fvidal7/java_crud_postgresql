package principal;

import java.util.Scanner;

import controllers.ClienteController;

public class Program {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n *** CONTROLE DE CLIENTES *** \n");
		System.out.println("(1) - Cadastrar cliente");
		System.out.println("(2) - Atualizar cliente");
		System.out.println(" (3) - Excluir cliente");
		System.out.println(" (4) - Consultar todos os clientes");

		System.out.print("\nEscolha uma opção: ");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		ClienteController clientecontroller = new ClienteController();

		switch (opcao) {

		case 1:// cadastrar cliente
			clientecontroller.cadastrarCliente();
			break;

		case 2:// atualizar cliente
			clientecontroller.atualizarCliente();
			break;

		case 3: // excluir cliente
			clientecontroller.excluirCliente();
			break;

		case 4: // consultar todos os clientes
			clientecontroller.consultarCliente();
			break;

		default:
			System.out.println("\nOpção inválida.");
			break;
		}

	}

}
