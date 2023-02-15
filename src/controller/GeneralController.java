package controller;

import java.io.BufferedReader;
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

		String codigo, sigla, mes, ano, uniPagadora, uf;

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
			System.out.print("Informe a UF da unidade pagadora: ");
			uf = input.next();

			fita.setCodigo(codigo);
			fita.setSigla(sigla);
			fita.setMes(mes);
			fita.setAno(ano);
			fita.setUniPagadora(uniPagadora);
			fita.setUf(uf);
		}

		// Valida e atualiza algumas informações da fita.
		validador.validateDadosInstitucionais(fita);
	}

	public void exportarArquivo() throws IOException {

		FileWriter arquivo = new FileWriter("file.txt");
		PrintWriter escritor = new PrintWriter(arquivo);

		// Recuperando servidores da lista de servidores.
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

		// Registrando dados pessoais dos servidores nas próximas linhas
		for (Servidor servidor : servidores) {
			// Registro dos dados pessoais dos servidores (Linha 2).
			escritor.print(fita.getUniPagadora());
			escritor.print(servidor.getSiape());
			escritor.print(servidor.getDigitoSIAPE());
			escritor.print("1");
			escritor.print(fita.getUf());
			escritor.print(servidor.getNome());
			escritor.print(servidor.getCpf());
			escritor.print(servidor.getPis());
			escritor.print(servidor.getNomeMae());
			escritor.print(servidor.getSexo());
			escritor.print(servidor.getDataNascimento());
			escritor.print(servidor.getEstadoCivil());
			escritor.print(servidor.getEscolaridade());
			escritor.print(servidor.getCodigoFormacao());
			escritor.print(servidor.getFiller2());
			escritor.print(servidor.getNacionalidade());
			escritor.print(servidor.getSiglaNaturalidade());
			escritor.print("000"); // Dados do país (Em geral vem com valor 0)
			escritor.print(servidor.getFiller3());
			escritor.print(servidor.getEndereco());
			escritor.print(servidor.getNumero());
			escritor.print(servidor.getComplemento());
			escritor.print(servidor.getBairro());
			escritor.print(servidor.getMunicipio());
			escritor.print(servidor.getCep());
			escritor.print(servidor.getUf());
			escritor.print(servidor.getRg());
			escritor.print(servidor.getOrgaoExpedidor());
			escritor.print(servidor.getDataExpedicao());
			escritor.print(servidor.getUfIdentidade());
			escritor.print(servidor.getTituloEleitor());
			escritor.print(servidor.getFiller4());
			escritor.print("\n");

			// Registro dos dados funcionais dos servidores (Linha 3).
			escritor.print(fita.getUniPagadora());
			escritor.print(servidor.getSiape());
			escritor.print(servidor.getDigitoSIAPE());
			escritor.print("2");
			escritor.print(fita.getUf());
			escritor.print(servidor.getSiglaRegime());
			escritor.print(servidor.getSituacaoServidor());
			escritor.print("000000"); // Carteira de trabalho
			escritor.print("       "); // Dados complementares da carteira
			escritor.print(servidor.getBanco());
			escritor.print(servidor.getAgencia());
			escritor.print(servidor.getContaBancaria());
			escritor.print("00000000000"); // Dados de FGTS
			escritor.print("                   "); // Dados complementares do FGTS
			escritor.print(servidor.getJornada());
			escritor.print("00"); // Percentual de tempo de serviço
			escritor.print(servidor.getDataCadastro());
			escritor.print(" "); // Supressão de pagamento
			escritor.print("0000000000000000"); // Dados de pagamento e proporcionalidade
			escritor.print(servidor.getGrupoCargo());
			escritor.print(servidor.getCargo());
			escritor.print(servidor.getClasseCargo());
			escritor.print(servidor.getNivelCargo());
			escritor.print(servidor.getDataEntrada());
			escritor.print(servidor.getDataSaida());
			escritor.print("   "); // Sigla Função
			escritor.print("00000"); // Código Função
			escritor.print("   "); // Escolaridade Função
			escritor.print("0000000000000000000000000"); // Dados complementares da função
			escritor.print("   "); // Sigla Nova Função
			escritor.print("00000"); // Código Nova Função
			escritor.print("   "); // Escolaridade Nova Função
			escritor.print("00000000000000000000000000000"); // Dados complementares da nova função
			escritor.print(servidor.getUnidadeLotacao());
			escritor.print(servidor.getDataIngressoUnidade());
			escritor.print("00000000000000000000000000000000      000000000000000000000000000     00000000000000000000000         00000000                                        000000000000000         00000000               0000 000000000000000000000000         00000000   0000000000000000000000000000000000000000000000000000000000000000000000000 0                                                                        00000000000000000 00000000000000000000000000000000000000000000000000000000000         00000000000000000000000         SSSSSSSSSSSSSSSSSSSSS");
			escritor.print("\n");
		}

		arquivo.close();
	}

	public void carregarDadosServidores() throws IOException {

		// Caminho de localização do arquivo de servidores.
		final String path = "/home/bzaum/servidores.txt";

		FileReader file = new FileReader(path);
		try (BufferedReader leitor = new BufferedReader(file)) {
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
				String nacionalidade = vector[11];
				String siglaNaturalidade = vector[12];
				String endereco = vector[13];
				String numero = vector[14];
				String complemento = vector[15];
				String bairro = vector[16];
				String municipio = vector[17];
				String cep = vector[18];
				String uf = vector[19];
				String rg = vector[20];
				String orgaoExpedidor = vector[21];
				String dataExpedicao = vector[22];
				String ufIdentidade = vector[23];
				String tituloEleitor = vector[24];
				String siglaRegime = vector[25];
				String situacaoServidor = vector[26];
				String banco = vector[27];
				String agencia = vector[28];
				String contaBancaria = vector[29];
				String jornada = vector[30];
				String dataCadastro = vector[31];
				String grupoCargo = vector[32];
				String cargo = vector[33];
				String classeCargo = vector[34];
				String nivelCargo = vector[35];
				String dataEntrada = vector[36];
				String dataSaida = vector[37];
				String unidadeLotacao = vector[38];
				String dataIngressoUnidade = vector[39];

				// Armazenando atributos pessoais do servidor.
				servidor.setSiape(siape);
				servidor.setDigitoSIAPE(digitoSIAPE);
				servidor.setNome(nome);
				servidor.setCpf(cpf);
				servidor.setPis(pis);
				servidor.setNomeMae(nomeMae);
				servidor.setSexo(sexo);
				servidor.setDataNascimento(dataNascimento);
				servidor.setEstadoCivil(estadoCivil);
				servidor.setEscolaridade(escolaridade);
				servidor.setCodigoFormacao(codigoFormacao);
				servidor.setNacionalidade(nacionalidade);
				servidor.setSiglaNaturalidade(siglaNaturalidade);
				servidor.setEndereco(endereco);
				servidor.setNumero(numero);
				servidor.setComplemento(complemento);
				servidor.setBairro(bairro);
				servidor.setMunicipio(municipio);
				servidor.setCep(cep);
				servidor.setUf(uf);
				servidor.setRg(rg);
				servidor.setOrgaoExpedidor(orgaoExpedidor);
				servidor.setDataExpedicao(dataExpedicao);
				servidor.setUfIdentidade(ufIdentidade);
				servidor.setTituloEleitor(tituloEleitor);

				// Armazenando atributos funcionais do servidor.
				servidor.setSiglaRegime(siglaRegime);
				servidor.setSituacaoServidor(situacaoServidor);
				servidor.setBanco(banco);
				servidor.setAgencia(agencia);
				servidor.setContaBancaria(contaBancaria);
				servidor.setJornada(jornada);
				servidor.setDataCadastro(dataCadastro);
				servidor.setGrupoCargo(grupoCargo);
				servidor.setCargo(cargo);
				servidor.setClasseCargo(classeCargo);
				servidor.setNivelCargo(nivelCargo);
				servidor.setDataEntrada(dataEntrada);
				servidor.setDataSaida(dataSaida);
				servidor.setUnidadeLotacao(unidadeLotacao);
				servidor.setDataIngressoUnidade(dataIngressoUnidade);

				// Adicionando servidor a lista de servidores.
				fita.addServidores(servidor);

				// Valida e atualiza dados pessoais dos servidores.
				validador.validateDadosPessoais(servidor);

				linha = leitor.readLine();
			}
		}

	}

}
