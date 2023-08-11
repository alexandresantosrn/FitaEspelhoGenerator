package controller;

import Util.MensagensUtil;
import model.FitaEspelhoServidore;
import model.Servidor;
import model.TamanhoCampos;
import model.Unidade;

public class Validator {
	String temp = "";
	int tamanhoFinalString = 0;
	String caractereCompletar = "";
	boolean retirarEspacos = false;

	public void validateDadosInstitucionais(FitaEspelhoServidore fita) throws Exception {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		temp = fita.getCodigo();
		tamanhoFinalString = TamanhoCampos.CODIGO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setCodigo(temp);
		} else {
			MensagensUtil.errosValidacao.add("Codigo da instituicao com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho da Sigla (Adiciona espaços à direita).
		temp = fita.getSigla();
		tamanhoFinalString = TamanhoCampos.SIGLA;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setSigla(temp);
		} else {
			MensagensUtil.errosValidacao.add("Codigo da instituicao com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do mes (Adiciona zeros a esquerda).
		temp = fita.getMes();
		int mes = Integer.parseInt(fita.getMes());
		tamanhoFinalString = TamanhoCampos.MES;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			if (mes > 0 && mes <= 12) {
				temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
				fita.setMes(temp);
			} else {
				MensagensUtil.errosValidacao.add("Mes invalido (" + temp + ")");
			}

		} else {
			MensagensUtil.errosValidacao.add("Mes com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do ano (Adiciona zeros a direita).
		temp = fita.getAno();
		tamanhoFinalString = TamanhoCampos.ANO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() == tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setAno(temp);
		} else {
			MensagensUtil.errosValidacao.add("Ano com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter exatamente " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		temp = fita.getFiller1();
		tamanhoFinalString = TamanhoCampos.FILLER1;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFiller1(temp);
		} else {
			MensagensUtil.errosValidacao.add("Codigo da instituicao com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho da unidade pagadora (Adiciona espaços à
		// esquerda).
		temp = fita.getUniPagadora();
		tamanhoFinalString = TamanhoCampos.UNIDADE_PAGADORA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setUniPagadora(temp);
		} else {
			MensagensUtil.errosValidacao.add("Codigo da instituicao com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler final (Adiciona espaços à direita).
		temp = fita.getFillerFim();
		tamanhoFinalString = TamanhoCampos.FILLER_FIM;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFillerFim(temp);
		} else {
			MensagensUtil.errosValidacao.add("Codigo da instituicao com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		/*
		 * if (Mensagens.errosValidacao.isEmpty()) {
		 * System.out.println("\nTodos os Campos formatados com sucesso!"); } else {
		 * String msg = "ERROS: \n \n"; for (String string : Mensagens.errosValidacao) {
		 * msg += string + "\n"; } throw new Exception(msg); }
		 */

	}

	public void validateDadosPessoais(Servidor servidor) {

		// Valida e atualiza matrícula SIAPE do servidor (Adiciona zeros à esquerda).
		temp = servidor.getSiape();
		tamanhoFinalString = TamanhoCampos.SIAPE;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setSiape(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Matricula SIAPE com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza o nome do servidor (Adiciona espaços à direita).
		temp = servidor.getNome();
		tamanhoFinalString = TamanhoCampos.NOME;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNome(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Nome do servidor com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza o nome da mãe do servidor (Adiciona espaços à direita).
		temp = servidor.getNomeMae();
		tamanhoFinalString = TamanhoCampos.NOME_MAE;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNomeMae(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Nome da mee com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler2 (Adiciona espaços à direita).
		temp = servidor.getFiller2();
		tamanhoFinalString = TamanhoCampos.FILLER2;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller2(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler2 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler3 (Adiciona zeros à direita).
		temp = servidor.getFiller3();
		tamanhoFinalString = TamanhoCampos.FILLER3;
		caractereCompletar = "0";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller3(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler3 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Endereço (Adiciona espaços à direita).
		temp = servidor.getEndereco();
		tamanhoFinalString = TamanhoCampos.ENDERECO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setEndereco(temp);
		} else {
			MensagensUtil.errosValidacao
					.add("Linha " + servidor.getLinhaArquivo() + " ->  Endereco com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do número (Adiciona espaços à direita) ou a
		// esquerda?.
		temp = servidor.getNumero();
		tamanhoFinalString = TamanhoCampos.NUMERO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNumero(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Numero do endereco com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do complemento (Adiciona espaços à direita).
		temp = servidor.getComplemento();
		tamanhoFinalString = TamanhoCampos.COMPLEMENTO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setComplemento(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Complemento no endereco com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do bairro (Adiciona espaços à direita).
		temp = servidor.getBairro();
		tamanhoFinalString = TamanhoCampos.BAIRRO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setBairro(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Bairro com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do município (Adiciona espaços à direita).
		temp = servidor.getMunicipio();
		tamanhoFinalString = TamanhoCampos.MUNICIPIO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setMunicipio(temp);
		} else {
			MensagensUtil.errosValidacao
					.add("Linha " + servidor.getLinhaArquivo() + " ->  Municipio com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do RG (Adiciona espaços à direita) ou a
		// esquerda?.
		temp = servidor.getRg();
		tamanhoFinalString = TamanhoCampos.RG;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setRg(temp);
		} else {
			MensagensUtil.errosValidacao
					.add("Linha " + servidor.getLinhaArquivo() + " ->  Numero RG com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do órgão expedidor do RG (Adiciona espaços à
		// direita).
		temp = servidor.getOrgaoExpedidor();
		tamanhoFinalString = TamanhoCampos.ORGAO_EXPEDIDOR;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setOrgaoExpedidor(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  orgao expedidor do RG com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do título do eleitor (Adiciona zeros à esquerda).
		temp = servidor.getTituloEleitor();
		tamanhoFinalString = TamanhoCampos.TITULO_ELEITOR;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setTituloEleitor(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Titulo eleitor com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler4 (Adiciona espacos à direita).
		temp = servidor.getFiller4();
		tamanhoFinalString = TamanhoCampos.FILLER4;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller4(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler4 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Agência Bancária (Adiciona zeros esquerda).
		temp = servidor.getAgencia();
		tamanhoFinalString = TamanhoCampos.AGENCIA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setAgencia(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Codigo da instituicao com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho da conta bancária (Adiciona espaços à esquerda).
		temp = servidor.getContaBancaria();
		tamanhoFinalString = TamanhoCampos.CONTA_BANCARIA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setContaBancaria(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Conta bancaria com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza data de desligamento do servidor (Adiciona zeros à
		// esquerda).
		temp = servidor.getDataSaida();
		tamanhoFinalString = TamanhoCampos.DATA_SAIDA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setDataSaida(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Data de saida com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza unidade de lotação do servidor (Adiciona zeros à
		// esquerda).
		temp = servidor.getUnidadeLotacao();
		tamanhoFinalString = TamanhoCampos.UNIDADE_LOTACAO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setUnidadeLotacao(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " -> Unidade de lotacao com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString
					+ " caracteres.");
		}

	}

	public void validateQtdServidores(FitaEspelhoServidore fita) {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		temp = fita.getQtdServidores();
		tamanhoFinalString = TamanhoCampos.QUANTIDADE_SERVIDORES;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setQtdServidores(temp);
		} else {
			MensagensUtil.errosValidacao.add("Quantidade de servidores com " + temp.length() + " caracteres (" + temp
					+ ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

	}

	public void validateDadosUnidades(Unidade unidade) {
		
		// Valida e atualiza id da unidade (Adiciona zeros à esquerda).
		temp = unidade.getIdUnidade();
		tamanhoFinalString = TamanhoCampos.ID_UNIDADE;
		caractereCompletar = "0";
		retirarEspacos = true;
		
		if (temp.length() <= tamanhoFinalString) {			
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setIdUnidade(temp);
		} else {
			
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  ID da UNIDADE com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
		
		// Valida e atualiza nome da unidade (Adiciona espacos à direita).
		temp = unidade.getNome();
		tamanhoFinalString = TamanhoCampos.NOME_UNIDADE;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setNome(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  Nome da UNIDADE com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
		
		// Valida e atualiza sigla da unidade (Adiciona espacos à direita).
		temp = unidade.getSigla();
		tamanhoFinalString = TamanhoCampos.SIGLA_UNIDADE;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setSigla(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  Sigla da UNIDADE com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
		
		// Valida e atualiza UF da unidade (Adiciona espacos à direita).
		temp = unidade.getUf();
		tamanhoFinalString = TamanhoCampos.UF_UNIDADE;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setUf(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  UF da UNIDADE com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza id da unidade pagadora (Adiciona zeros à esquerda).
		temp = unidade.getIdUnidadePagadora();
		tamanhoFinalString = TamanhoCampos.ID_UNIDADE_PAGADORA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setIdUnidadePagadora(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  ID da UNIDADE PAGADORA com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
		
		// Valida e atualiza unidade gestora (Adiciona zeros à esquerda).
		temp = unidade.getUnidadeGestora();
		tamanhoFinalString = TamanhoCampos.UNIDADE_GESTORA;
		caractereCompletar = "0";
		retirarEspacos = true;
		
		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setUnidadeGestora(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " ->  UNIDADE GESTORA com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
		
		// Valida e atualiza unidade antecedente (Adiciona espaços à direita).
		temp = unidade.getUnidadeAntecedente();
		tamanhoFinalString = TamanhoCampos.UNIDADE_ANTECEDENTE;
		caractereCompletar = " ";
		retirarEspacos = false;
		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setUnidadeAntecedente(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + unidade.getLinhaArquivo() + " -> UNIDADE ANTECEDENTE com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no maximo " + tamanhoFinalString + " caracteres.");
		}
	}

	public static String completarCaracteresEsquerda(String originalString, int tamanhoFinalString, String caractere,
			boolean tirarEspacos) {

		String temp = "";
		if (tirarEspacos) {
			temp = originalString.trim().replaceAll("\\s+", ""); // retira todos os espaço da string
		} else {
			temp = originalString.trim(); // tira os espaços do inicio e fim da string
		}

		if (temp.length() >= tamanhoFinalString) {
			return temp;
		}

		StringBuilder paddedString = new StringBuilder();
		int quantCaracteresAdicionar = tamanhoFinalString - temp.length();
		for (int i = 0; i < quantCaracteresAdicionar; i++) {
			paddedString.append(caractere);
		}
		paddedString.append(temp);

		return paddedString.toString();
	}

	public static String completarCaracteresDireita(String originalString, int tamanhoFinalString, String caractere,
			boolean tirarEspacos) {

		String temp = "";
		if (tirarEspacos) {
			temp = originalString.trim().replaceAll("\\s+", ""); // retira todos os espaco da string
		} else {
			temp = originalString.trim(); // tira os espaçsendEmailUPTos do inicio e fim da string
		}

		if (temp.length() == tamanhoFinalString) {
			return temp;
		}

		StringBuilder paddedString = new StringBuilder(temp);
		int quantCaracteresAdicionar = tamanhoFinalString - temp.length();
		for (int i = 0; i < quantCaracteresAdicionar; i++) {
			paddedString.append(caractere);
		}

		return paddedString.toString();
	}

}
