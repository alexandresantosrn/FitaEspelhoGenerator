package view;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {

		int option = 10;

		try (Scanner input = new Scanner(System.in)) {
			while (option != 0) {

				System.out.println("Informe a opção desejada: ");
				System.out.println("1 - Importar arquivos:");
				System.out.println("0 - Sair");
				System.out.print("Opção: ");
				option = input.nextInt();
			}

			switch (option) {

			case 1: {
				System.out.println("xxx");
			}

			default:
				break;
			}
		}

		System.out.println(" \n" + "Até logo!!!!");
	}

}
