package controller;

import Util.MensagensUtil;
import model.FitaEspelho;
import model.Servidor;
import model.TamanhoCampos;
import model.Unidade;

public class Validator {
	String temp = "";
	int tamanhoFinalString = 0;
	String caractereCompletar = "";
	boolean retirarEspacos = false;

	public void validateDadosInstitucionais(FitaEspelho fita) throws Exception {

		// Valida e atualiza tamanho do c√≥digo (Adiciona zeros √† esquerda).
		temp = fita.getCodigo();
		tamanhoFinalString = TamanhoCampos.CODIGO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setCodigo(temp);
		} else {
			MensagensUtil.errosValidacao.add("CÛdigo da instituiÁ„o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho da Sigla (Adiciona espa√ßos √† direita).
		temp = fita.getSigla();
		tamanhoFinalString = TamanhoCampos.SIGLA;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setSigla(temp);
		} else {
			MensagensUtil.errosValidacao.add("CÛdigo da instituiÁ„o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do mÍs (Adiciona zeros a esquerda).
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
				MensagensUtil.errosValidacao.add("MÍs inv·lido (" + temp + ")");
			}

		} else {
			MensagensUtil.errosValidacao.add("MÍs com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do ano (Adiciona zeros† direita).
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

		// Valida e atualiza tamanho do Filler1 (Adiciona espa√ßos √† direita).
		temp = fita.getFiller1();
		tamanhoFinalString = TamanhoCampos.FILLER1;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFiller1(temp);
		} else {
			MensagensUtil.errosValidacao.add("CÛdigo da instituiÁ„o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho da unidade pagadora (Adiciona espa√ßos √†
		// esquerda).
		temp = fita.getUniPagadora();
		tamanhoFinalString = TamanhoCampos.UNIDADE_PAGADORA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setUniPagadora(temp);
		} else {
			MensagensUtil.errosValidacao.add("CÛdigo da instituiÁ„o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler final (Adiciona espa√ßos √† direita).
		temp = fita.getFillerFim();
		tamanhoFinalString = TamanhoCampos.FILLER_FIM;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFillerFim(temp);
		} else {
			MensagensUtil.errosValidacao.add("CÛdigo da instituiÁ„o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		/*
		 * if (Mensagens.errosValidacao.isEmpty()) {
		 * System.out.println("\nTodos os Campos formatados com sucesso!"); } else {
		 * String msg = "ERROS: \n \n"; for (String string : Mensagens.errosValidacao) {
		 * msg += string + "\n"; } throw new Exception(msg); }
		 */

	}

	public void validateDadosPessoais(Servidor servidor) {

		// Valida e atualiza matr√≠cula SIAPE do servidor (Adiciona zeros √† esquerda).
		temp = servidor.getSiape();
		tamanhoFinalString = TamanhoCampos.SIAPE;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setSiape(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Matricula SIAPE com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza o nome do servidor (Adiciona espa√ßos √† direita).
		temp = servidor.getNome();
		tamanhoFinalString = TamanhoCampos.NOME;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNome(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Nome do servidor com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza o nome da m√£e do servidor (Adiciona espa√ßos √† direita).
		temp = servidor.getNomeMae();
		tamanhoFinalString = TamanhoCampos.NOME_MAE;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNomeMae(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Nome da m„e com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler2 (Adiciona espa√ßos √† direita).
		temp = servidor.getFiller2();
		tamanhoFinalString = TamanhoCampos.FILLER2;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller2(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler2 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler3 (Adiciona zeros √† direita).
		temp = servidor.getFiller3();
		tamanhoFinalString = TamanhoCampos.FILLER3;
		caractereCompletar = "0";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller3(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler3 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Endere√ßo (Adiciona espa√ßos √† direita).
		temp = servidor.getEndereco();
		tamanhoFinalString = TamanhoCampos.ENDERECO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setEndereco(temp);
		} else {
			MensagensUtil.errosValidacao
					.add("Linha " + servidor.getLinhaArquivo() + " ->  EndereÁo com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do n√∫mero (Adiciona espa√ßos √† direita) ou a
		// esquerda?.
		temp = servidor.getNumero();
		tamanhoFinalString = TamanhoCampos.NUMERO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setNumero(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  N˙mero do endereÁo com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do complemento (Adiciona espa√ßos √† direita).
		temp = servidor.getComplemento();
		tamanhoFinalString = TamanhoCampos.COMPLEMENTO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setComplemento(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Complemento no endereÁo com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do bairro (Adiciona espa√ßos √† direita).
		temp = servidor.getBairro();
		tamanhoFinalString = TamanhoCampos.BAIRRO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setBairro(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Bairro com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do munic√≠pio (Adiciona espa√ßos √† direita).
		temp = servidor.getMunicipio();
		tamanhoFinalString = TamanhoCampos.MUNICIPIO;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setMunicipio(temp);
		} else {
			MensagensUtil.errosValidacao
					.add("Linha " + servidor.getLinhaArquivo() + " ->  MunicÌpio com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do RG (Adiciona espa√ßos √† direita) ou a
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
					.add("Linha " + servidor.getLinhaArquivo() + " ->  N˙mero RG com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do √≥rg√£o expedidor do RG (Adiciona espa√ßos √†
		// direita).
		temp = servidor.getOrgaoExpedidor();
		tamanhoFinalString = TamanhoCampos.ORGAO_EXPEDIDOR;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setOrgaoExpedidor(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  ”rg„o expedidor do RG com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho do t√≠tulo do eleitor (Adiciona zeros √† esquerda).
		temp = servidor.getTituloEleitor();
		tamanhoFinalString = TamanhoCampos.TITULO_ELEITOR;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setTituloEleitor(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  TÌtulo eleitor com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler4 (Adiciona espaÁos √† direita).
		temp = servidor.getFiller4();
		tamanhoFinalString = TamanhoCampos.FILLER4;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresDireita(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setFiller4(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  Filler4 com " + temp.length()
					+ " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Ag√™ncia Banc√°ria (Adiciona zeros esquerda).
		temp = servidor.getAgencia();
		tamanhoFinalString = TamanhoCampos.AGENCIA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setAgencia(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  CÛdigo da instituiÁ„o com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

		// Valida e atualiza tamanho da conta banc√°ria (Adiciona espa√ßos √† esquerda).
		temp = servidor.getContaBancaria();
		tamanhoFinalString = TamanhoCampos.CONTA_BANCARIA;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setContaBancaria(temp);
		} else {
			MensagensUtil.errosValidacao.add(
					"Linha " + servidor.getLinhaArquivo() + " ->  Conta banc·ria com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza data de desligamento do servidor (Adiciona zeros √†
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
					"Linha " + servidor.getLinhaArquivo() + " ->  Data de saÌda com " + temp.length() + " caracteres ("
							+ temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza unidade de lota√ß√£o do servidor (Adiciona zeros √†
		// esquerda).
		temp = servidor.getUnidadeLotacao();
		tamanhoFinalString = TamanhoCampos.UNIDADE_LOTACAO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			servidor.setUnidadeLotacao(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + servidor.getLinhaArquivo() + " ->  CUnidade de lotaÁ„o com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}

	}

	public void validateQtdServidores(FitaEspelho fita) {

		// Valida e atualiza tamanho do c√≥digo (Adiciona zeros √† esquerda).
		temp = fita.getQtdServidores();
		tamanhoFinalString = TamanhoCampos.QUANTIDADE_SERVIDORES;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setQtdServidores(temp);
		} else {
			MensagensUtil.errosValidacao.add("Quantidade de servidores com " + temp.length() + " caracteres (" + temp
					+ ")" + ". Deveria ter no m·ximo " + tamanhoFinalString + " caracteres.");
		}

	}

	public void validateDadosUnidades(Unidade unidade) {
//		idUnidade, nome, sigla, uf, idUnidadePagadora, unidadeGestora, unidadeAntecedente;
		// Valida e atualiza id da unidade (Adiciona zeros √† esquerda).
		temp = unidade.getIdUnidade();
		tamanhoFinalString = TamanhoCampos.ID_UNIDADE;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			unidade.setIdUnidade(temp);
		} else {
			MensagensUtil.errosValidacao.add("Linha " + unidade.getLinhaArquivo() + " ->  Id da UNIDADE com "
					+ temp.length() + " caracteres (" + temp + ")" + ". Deveria ter no m·ximo " + tamanhoFinalString
					+ " caracteres.");
		}
	}

	public static String completarCaracteresEsquerda(String originalString, int tamanhoFinalString, String caractere,
			boolean tirarEspaÁos) {

		String temp = "";
		if (tirarEspaÁos) {
			temp = originalString.trim().replaceAll("\\s+", ""); // retira todos os espaÁo da string
		} else {
			temp = originalString.trim(); // tira os espaÁos do inicio e fim da string
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
			boolean tirarEspaÁos) {

		String temp = "";
		if (tirarEspaÁos) {
			temp = originalString.trim().replaceAll("\\s+", ""); // retira todos os espaÁo da string
		} else {
			temp = originalString.trim(); // tira os espaÁos do inicio e fim da string
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
