package view;

import java.io.IOException;
import java.util.Scanner;
import controller.MainController;
import util.MensagensUtil;

public class Index {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException, Exception {

		int option = 1000;		
		
			while (option != 0) {
				ClearConsole();
				System.out.println("\n #### GERADOR DE FITA ESPELHO SIGRH #### \n ");
				
				if(!MensagensUtil.errosValidacao.isEmpty()) {
					System.out.println("-- -- --- ERROS DE VALIDACAO --- -- --");
					for (String string : MensagensUtil.errosValidacao) {
						System.out.println(string);
					}
					System.out.println("-- -- --- ERROS DE VALIDACAO --- -- --\n\n");
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
				
				System.out.println("\tInforme a opcao desejada: ");
				System.out.println("\t\t1 - Gerar Fita Espelho SERVIDORES");
				//System.out.println("\t\t2 - Gerar Fita Espelho UNIDADES");
				System.out.println("\t\t0 - Sair");
				System.out.print("\tOpcao: ");
				option = input.nextInt();

				switch (option) {
				case 1: {
					MainController controlador = new MainController();
					System.out.println("\n #######  FITA ESPELHO SERVIDORES #######\n");
					controlador.carregarServidores();
					break;
				}
//				case 2: {
//					MainController controlador = new MainController();
//					System.out.println("\n #######  FITA ESPELHO UNIDADES #######\n");
//					controlador.carregarUnidades();
//					break;
//				}
				
				default:
					break;
				}
				
				break;
			}		

		System.out.println(" \n" + "Finalizando. Ate logo!!!!");
		input.close();
		System.exit(0);
	}

	public static void ClearConsole() {
		try {
	        if (System.getProperty("os.name").toLowerCase().contains("win")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            System.out.print("\033[H\033[2J");
	            System.out.flush();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}