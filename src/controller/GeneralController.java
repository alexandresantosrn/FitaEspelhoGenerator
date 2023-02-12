package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.FitaEspelho;
import model.Servidor;

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

		// Valida e atualiza algumas informações da fita.
		validador.validate(fita);
	}

	public void exportarArquivo() throws IOException {

		FileWriter arquivo = new FileWriter("file.txt");
		PrintWriter escritor = new PrintWriter(arquivo);

		List<Servidor> servidores = new ArrayList<>();
		servidores = fita.getServidores();

		// Registrando dados da instituição no arquivo.
		escritor.print(fita.getConstante());
		escritor.print(fita.getNome());
		escritor.print(fita.getCodigo());
		escritor.print(fita.getSigla());
		escritor.print(fita.getMes());
		escritor.print(fita.getAno());
		escritor.print(fita.getFiller1());
		escritor.print("\n");

		// Registrando dados pessoais dos servidores na segunda linha;
		for (Servidor servidor : servidores) {
			escritor.print(fita.getUniPagadora());
			escritor.print(servidor.getSIAPE());
			escritor.print(servidor.getDigitoSIAPE());
			escritor.print("1");
			escritor.print(servidor.getNome());
			escritor.print(servidor.getCpf());
			escritor.print(servidor.getPis());
			escritor.print(servidor.getNomeMae());
			escritor.print(servidor.getSexo());
			escritor.print(servidor.getDataNascimento());
			escritor.print(servidor.getEstadoCivil());
			escritor.print(servidor.getEscolaridade());
			escritor.print(servidor.getCodigoFormacao());
		}

		arquivo.close();
	}

	public void carregarDadosPessoaisServidores() throws IOException {

		// Caminho de localização do arquivo de servidores.
		final String path = "/home/bzaum/servidores.txt";

		FileReader file = new FileReader(path);
		BufferedReader leitor = new BufferedReader(file);

		// Variável de leitura da linha.
		String linha = leitor.readLine();

		while (linha != null) {

			Servidor servidor = new Servidor();

			String vector[] = linha.split(";");

			String siape = vector[0];
			String digitoSIAPE = vector[1];
			String nome = vector[2];
			String cpf = vector[3];
			String pis = vector[4];
			String nomeMae = vector[5];
			String sexo = vector[6];
			String dataNascimento = vector[7];
			String estadoCivil = vector[8];
			String escolaridade = vector[9];
			String codigoFormacao = vector[10];

			// Armazenando atributos do servidor.
			servidor.setSIAPE(siape);
			servidor.setDigitoSIAPE(digitoSIAPE);
			servidor.setNome(nome);
			servidor.setCpf(cpf);
			servidor.setPIS(pis);
			servidor.setNomeMae(nomeMae);
			servidor.setSexo(sexo);
			servidor.setDataNascimento(dataNascimento);
			servidor.setEstadoCivil(estadoCivil);
			servidor.setEscolaridade(escolaridade);
			servidor.setCodigoFormacao(codigoFormacao);

			// Adicionando servidor a lista de servidores.
			fita.addServidores(servidor);

			linha = leitor.readLine();
		}

	}

}
