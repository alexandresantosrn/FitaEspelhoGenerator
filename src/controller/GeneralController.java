package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.FitaEspelho;
import model.Servidor;

public class GeneralController {

	FitaEspelho fita = new FitaEspelho();
	Validator validador = new Validator();
	Scanner input = new Scanner(System.in);
	int qtdServidores;

	public void informarDadosInstituicao() throws Exception {
		LocalDate dataAtual = LocalDate.now();

		String codigo = "00688", sigla = "UESB";
		String mes = "" + dataAtual.getMonthValue();
		String ano = "" + dataAtual.getYear(), uniPagadora = "38000", uf = "BA";

		String temp = "";

		try {
			System.out.print("\t\tInforme o c�digo da institui��o: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				codigo = temp;
			}
			System.out.print("\t\tInforme a sigla da institui��o: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				sigla = temp;
			}
			System.out.print("\t\tInforme o m�s desejado: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				mes = temp;
			}
			System.out.print("\t\tInforme o ano desejado: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				ano = temp;
			}
			System.out.print("\t\tInforme o c�digo SIAPECAD da unidade pagadora: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				uniPagadora = temp;
			}
			System.out.print("\t\tInforme a UF da unidade pagadora: ");
			temp = input.nextLine();
			if (!temp.isEmpty() && !temp.isBlank()) {
				uf = temp;
			}

			fita.setCodigo(codigo);
			fita.setSigla(sigla.toUpperCase());
			fita.setMes(mes);
			fita.setAno(ano);
			fita.setUniPagadora(uniPagadora);
			fita.setUf(uf.toUpperCase());
			
			fita.printCabecalho();
		} catch (Exception e) {
			throw new Exception("\nERRO2: " + e.getMessage());
		}

		// Valida e atualiza algumas informações da fita.
		try {
			validador.validateDadosInstitucionais(fita);
		} catch (Exception e) {
			throw new Exception("\nERRO3: " + e.getMessage());
			
		}
	}

	public void carregarDadosServidores() throws IOException, Exception {

		// Caminho de localização do arquivo de servidores.
		String path = new File(".").getCanonicalPath() + "\\arquivo_servidores\\servidores.txt";
		int opcao = 0;

		try {
			System.out.println("\nAlterar caminho de localiza��o do arquivo de servidores?  ");
			System.out.println("\tLocal atual: " + path);
			System.out.println("\t\t1 - Sim");
			System.out.println("\t\t0 - N�o");
			System.out.print("\t\tOp��o: ");
			opcao = input.nextInt();

			if (opcao == 1) {
				System.out.println("\nDigite o caminho da localiza��o do arquivo:");
				path = input.next();
			}

			FileReader file = new FileReader(path);
			try {
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
					String admissaoOrgao = vector[40];
					String admissaoServicoPublico = vector[41];

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
					servidor.setAdmissaoOrgao(admissaoOrgao);
					servidor.setAdmissaoServicoPublico(admissaoServicoPublico);

					// Adicionando servidor a lista de servidores.
					fita.addServidores(servidor);

					// Valida e atualiza dados pessoais dos servidores.
					validador.validateDadosPessoais(servidor);

					qtdServidores++;
					fita.setQtdServidores(Integer.toString(qtdServidores));
					validador.validateQtdServidores(fita);

					linha = leitor.readLine();
				}
				leitor.close();
			} catch (Exception e) {
				throw new Exception("ERRO4 " + e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception("ERRO3 " + e.getMessage());
		}
	}

	public void exportarArquivo() throws IOException {
		LocalDateTime date = LocalDateTime.now();
		String pastaArquivosFitasEspelho = new File(".").getCanonicalPath() + "\\arquivos_fitas_espelho_geradas";
		String nomeArquivoFitaEspelho = "fita_espelho_" + date.getYear() + date.getMonthValue() + date.getDayOfMonth()
				+ date.getHour() + date.getMinute() + date.getSecond() + ".txt";
		String caminhoArquivoFitaEspelho = pastaArquivosFitasEspelho + "\\" + nomeArquivoFitaEspelho;

		File file = new File(pastaArquivosFitasEspelho);
		if (!file.exists()) {
			file.mkdirs();
		}

		FileWriter arquivo = new FileWriter(caminhoArquivoFitaEspelho);
		PrintWriter escritor = new PrintWriter(arquivo);

		// Recuperando servidores da lista de servidores.
		List<Servidor> servidores = new ArrayList<>();
		servidores = fita.getServidores();

		// Registrando dados da instituição no arquivo.
		escritor.print(fita.getConstante()); // Constantes com zeros.
		escritor.print(fita.getNome()); // Nome: SIAPEFITAESP.
		escritor.print(fita.getCodigo()); // Código da instituição.
		escritor.print(fita.getSigla()); // Sigla da instituição.
		escritor.print(fita.getMes()); // Mês de referência.
		escritor.print(fita.getAno()); // Ano de referência.
		escritor.print(fita.getFiller1()); // Filler do Header0.
		escritor.print("\n");

		// Registrando dados pessoais dos servidores nas próximas linhas
		for (Servidor servidor : servidores) {
			// Registro dos dados pessoais dos servidores (Linha 2).
			escritor.print(fita.getUniPagadora()); // Siapecad da unidade pagadora.
			escritor.print(servidor.getSiape()); // Siape do servidor.
			escritor.print(servidor.getDigitoSIAPE()); // Dígito Siape do servidor.
			escritor.print("1"); // Código de registro 1.
			escritor.print(fita.getUf());
			escritor.print(servidor.getNome()); // Nome do servidor.
			escritor.print(servidor.getCpf()); // Cpf do servidor.
			escritor.print(servidor.getPis()); // Pis do servidor.
			escritor.print(servidor.getNomeMae()); // Nome da mãe do servidor.
			escritor.print(servidor.getSexo()); // Sexo do servidor.
			escritor.print(servidor.getDataNascimento()); // Data de Nascimento do servidor.
			escritor.print(servidor.getEstadoCivil()); // Código(DB) do estado civil do servidor.
			escritor.print(servidor.getEscolaridade()); // Código(DB) da escolaridade do servidor.
			escritor.print(servidor.getCodigoFormacao()); // Código(DB) da formação do servidor.
			escritor.print(servidor.getFiller2());
			escritor.print(servidor.getNacionalidade()); // Valor padrão: 1.
			escritor.print(servidor.getSiglaNaturalidade()); // Ex: RN
			escritor.print("000"); // Dados do país (Em geral vem com valor 0)
			escritor.print(servidor.getFiller3()); // Filler.
			escritor.print(servidor.getEndereco()); // Endereço do servidor.
			escritor.print(servidor.getNumero()); // Número da residência do servidor.
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
			// escritor.print(
			// "00000000000000000000000000000000 000000000000000000000000000
			// 00000000000000000000000 00000000 000000000000000 00000000 0000
			// 000000000000000000000000 00000000
			// 0000000000000000000000000000000000000000000000000000000000000000000000000 0
			// 00000000000000000 00000000000000000000000000000000000000000000000000000000000
			// 00000000000000000000000 SSSSSSSSSSSSSSSSSSSSS");
			escritor.print("0000000000000000000");
			escritor.print(servidor.getAdmissaoOrgao()); // Data de admissão no órgão.
			escritor.print("00000");
			escritor.print("      ");
			escritor.print("0000000000000");
			escritor.print(servidor.getAdmissaoServicoPublico());
			escritor.print(
					"000000     00000000000000000000000         00000000                                        000000000000000         00000000               0000 000000000000000000000000         00000000   0000000000000000000000000000000000000000000000000000000000000000000000000 0                                                                        00000000000000000 00000000000000000000000000000000000000000000000000000000000         00000000000000000000000         SSSSSSSSSSSSSSSSSSSSS");
			escritor.print("\n");
		}

		escritor.print("999999999999999999");
		// escritor.print("000000002"); // Quantidade de servidores
		escritor.print(fita.getQtdServidores()); // Quantidade de servidores
		escritor.print(fita.getFillerFim());

		escritor.close();
		arquivo.close();
	}

}
