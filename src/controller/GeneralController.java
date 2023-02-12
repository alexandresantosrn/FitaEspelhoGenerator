package controller;

import java.util.Scanner;

import model.FitaEspelho;

public class GeneralController {

	public void informarDadosInstituicao() {
		
		String codigo, sigla, mes, ano;		
		FitaEspelho fita = new FitaEspelho();

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Informe o código da instuição: ");
			codigo = input.next();
			System.out.print("Informe a sigla da instituição: ");
			sigla = input.next();
			System.out.print("Informe o mês desejado: ");
			mes = input.next();
			System.out.println("Informe o ano desejado: ");
			ano = input.next();
			
			fita.setCodigo(codigo);
			fita.setSigla(sigla);
			fita.setMes(mes);
			fita.setAno(ano);
		}
		
		
	}

	public void exportarArquivo() {
		
		
		
	}

	

	

}
