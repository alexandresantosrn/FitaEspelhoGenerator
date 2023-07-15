package view;

import java.io.IOException;
import java.util.Scanner;

import Util.MensagensUtil;
import controller.MainController;

public class Index {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException, Exception {

		int option = 10;
		MainController controlador = new MainController();

		//try {
			while (option != 0) {
				ClearConsole();
				System.out.println("\n #### GERADOR DE FITA ESPELHO SIGAA #### \n ");
				
				if(!MensagensUtil.errosValidacao.isEmpty()) {
					System.out.println("-- -- --- ERROS DE VALIDA��O --- -- --");
					for (String string : MensagensUtil.errosValidacao) {
						System.out.println(string);
					}
					System.out.println("-- -- --- ERROS DE VALIDA��O --- -- --\n\n");
				}
				
				if(!MensagensUtil.msg.isEmpty()) {
					System.out.println("-- -- --- MENSAGENS --- -- --");
					for (String string : MensagensUtil.msg) {
						System.out.println(string);
					}
					System.out.println("-- -- --- MENSAGENS --- -- --\n");
				}
				
				MensagensUtil.errosValidacao.clear();
				MensagensUtil.msg.clear();
				
				System.out.println("\tInforme a op��o desejada: ");
				System.out.println("\t\t1 - Importar arquivo");
				System.out.println("\t\t0 - Sair");
				System.out.print("\tOp��o: ");
				option = input.nextInt();

				switch (option) {
				case 1: {
					System.out.println("\nApresentando informa��es...\n");
					controlador.carregar();
					break;
				}
				default:
					break;
				}
			}

		/*} catch (Exception e) {
			e.printStackTrace();
			input.close();
			System.exit(1);
		}*/

		System.out.println(" \n" + "At� logo!!!!");
		input.close();
		System.exit(0);
	}

	public static void ClearConsole() {
		try {
			String operatingSystem = System.getProperty("os.name"); // Check the current operating system

			if (operatingSystem.contains("Windows")) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			} else {
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
