package view;

import java.io.IOException;
import java.util.Scanner;
import controller.MainController;

public class Index {

	public static void main(String[] args) throws IOException {

		int option = 10;
		MainController controlador = new MainController();

		try (Scanner input = new Scanner(System.in)) {
			while (option != 0) {

				System.out.println("Informe a opção desejada: ");
				System.out.println("1 - Importar arquivo");
				System.out.println("0 - Sair");
				System.out.print("Opção: ");		
				
				if (input.hasNextInt()) {
					option = input.nextInt();
				}	
				
				if(option != 10) {
					System.out.println("Opção Escolhida: " + option);
				}
				
				switch (option) {

				case 1: {
					System.out.println("Apresentando informações...");
					controlador.carregar();
					break;
				}

				default:
					break;
				}
				
				break;				
			}

		}

		System.out.println(" \n" + "Até logo!!!!");
	}

}