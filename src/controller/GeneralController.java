package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.FitaEspelho;

public class GeneralController {

	FitaEspelho fita = new FitaEspelho();
	Validator validador = new Validator();

	public void informarDadosInstituicao() {

		String codigo, sigla, mes, ano;

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Informe o código da instuição: ");
			codigo = input.next();
			System.out.print("Informe a sigla da instituição: ");
			sigla = input.next();
			System.out.print("Informe o mês desejado: ");
			mes = input.next();
			System.out.print("Informe o ano desejado: ");
			ano = input.next();

			fita.setCodigo(codigo);
			fita.setSigla(sigla);
			fita.setMes(mes);
			fita.setAno(ano);
		}

	}

	public void exportarArquivo() throws IOException {

		FileWriter arquivo = new FileWriter("file.csv");
		PrintWriter escritor = new PrintWriter(arquivo);
		
		//Valida e atualiza algumas informações da fita.
		validador.validate(fita);

		//Registrando dados no arquivo.
		escritor.print(fita.getConstante());
		escritor.print(fita.getNome());
		escritor.print(fita.getCodigo());
		escritor.print(fita.getSigla());

		arquivo.close();
	}

}
