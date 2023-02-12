package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.FitaEspelho;

public class GeneralController {

	FitaEspelho fita = new FitaEspelho();
	Validator validador = new Validator();

	public void informarDadosInstituicao() {

		String codigo, sigla, mes, ano, uniPagadora;

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Informe o código da instuição: ");
			codigo = input.next();
			System.out.print("Informe a sigla da instituição: ");
			sigla = input.next();
			System.out.print("Informe o mês desejado: ");
			mes = input.next();
			System.out.print("Informe o ano desejado: ");
			ano = input.next();
			System.out.print("Informe o código SIAPECAD da unidade pagadora: ");
			uniPagadora = input.next();
			
			fita.setCodigo(codigo);
			fita.setSigla(sigla);
			fita.setMes(mes);
			fita.setAno(ano);
			fita.setUniPagadora(uniPagadora);
		}

	}

	public void exportarArquivo() throws IOException {

		FileWriter arquivo = new FileWriter("file.txt");
		PrintWriter escritor = new PrintWriter(arquivo);

		// Valida e atualiza algumas informações da fita.
		validador.validate(fita);

		// Registrando dados da instituição no arquivo.
		escritor.print(fita.getConstante());
		escritor.print(fita.getNome());
		escritor.print(fita.getCodigo());
		escritor.print(fita.getSigla());
		escritor.print(fita.getMes());
		escritor.print(fita.getAno());
		escritor.print(fita.getFiller1());
		escritor.print("\n");
		
		//Registrando dados pessoais do servidor na segunda linha;
		escritor.print(fita.getUniPagadora());

		arquivo.close();
	}

	public void carregarDadosServidores() throws IOException {
		
		// Caminho de localização do arquivo de servidores.
		final String path = "/home/bzaum/servidores.txt"; 	
		
		FileReader file = new FileReader(path);
		BufferedReader leitor = new BufferedReader(file);
		
		// Variável de leitura da linha.
		String linha = leitor.readLine();
		
		while (linha != null) {
			
			String vector[] = linha.split(";");
			
			
			
			linha = leitor.readLine();
			
		}
		
		
		
	}

}
