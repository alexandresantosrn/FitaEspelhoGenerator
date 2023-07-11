package controller;

import model.FitaEspelho;
import model.Servidor;
import model.TamanhoCampos;
import view.Mensagens;

public class Validator {

	public void validateDadosInstitucionais(FitaEspelho fita) throws Exception {

		
		
		String temp = "";
		int tamanhoFinalString = 0;
		String caractereCompletar = "";
		boolean retirarEspacos = false;

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		temp = fita.getCodigo();
		tamanhoFinalString = TamanhoCampos.CODIGO;
		caractereCompletar = "0";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setCodigo(temp);
		} else {
			Mensagens.errosValidacao.add("C�digo da institui��o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m�ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho da Sigla (Adiciona espaços à direita).
		temp = fita.getSigla();
		tamanhoFinalString = TamanhoCampos.SIGLA;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setSigla(temp);
		} else {
			Mensagens.errosValidacao.add("C�digo da institui��o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m�ximo " + tamanhoFinalString + " caracteres.");
		}

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		temp = fita.getFiller1();
		tamanhoFinalString = TamanhoCampos.FILLER1;
		caractereCompletar = " ";
		retirarEspacos = false;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFiller1(temp);
		} else {
			Mensagens.errosValidacao.add("C�digo da institui��o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m�ximo " + tamanhoFinalString + " caracteres.");
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
			Mensagens.errosValidacao.add("C�digo da institui��o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m�ximo " + tamanhoFinalString + " caracteres.");
		}
	

		// Valida e atualiza tamanho do Filler final (Adiciona espaços à direita).
		temp = fita.getFillerFim();
		tamanhoFinalString = TamanhoCampos.FILLER_FIM;
		caractereCompletar = " ";
		retirarEspacos = true;

		if (temp.length() <= tamanhoFinalString) {
			temp = completarCaracteresEsquerda(temp, tamanhoFinalString, caractereCompletar, retirarEspacos);
			fita.setFillerFim(temp);
		} else {
			Mensagens.errosValidacao.add("C�digo da institui��o com " + temp.length() + " caracteres (" + temp + ")"
					+ ". Deveria ter no m�ximo " + tamanhoFinalString + " caracteres.");
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
		while (servidor.getSiape().length() < 7) {
			String zeros = "0";
			String siape = zeros + servidor.getSiape();

			servidor.setSiape(siape);
		}

		// Valida e atualiza o nome do servidor (Adiciona espaços à direita).
		while (servidor.getNome().length() < 60) {
			String brancos = " ";
			String nome = servidor.getNome() + brancos;

			servidor.setNome(nome);
		}

		// Valida e atualiza o nome da mãe do servidor (Adiciona espaços à direita).
		while (servidor.getNomeMae().length() < 50) {
			String brancos = " ";
			String nomeMae = servidor.getNomeMae() + brancos;

			servidor.setNomeMae(nomeMae);
		}

		// Valida e atualiza tamanho do Filler2 (Adiciona espaços à direita).
		while (servidor.getFiller2().length() < 5) {
			String brancos = " ";
			String filler2 = servidor.getFiller2() + brancos;

			servidor.setFiller2(filler2);
		}

		// Valida e atualiza tamanho do Filler3 (Adiciona zeros à direita).
		while (servidor.getFiller3().length() < 24) {
			String zeros = "0";
			String filler3 = servidor.getFiller3() + zeros;

			servidor.setFiller3(filler3);
		}

		// Valida e atualiza tamanho do Endereço (Adiciona espaços à direita).
		while (servidor.getEndereco().length() < 40) {
			String brancos = " ";
			String endereco = servidor.getEndereco() + brancos;

			servidor.setEndereco(endereco);
		}

		// Valida e atualiza tamanho do número (Adiciona espaços à direita).
		while (servidor.getNumero().length() < 6) {
			String brancos = " ";
			String numero = servidor.getNumero() + brancos;

			servidor.setNumero(numero);
		}

		// Valida e atualiza tamanho do complemento (Adiciona espaços à direita).
		while (servidor.getComplemento().length() < 21) {
			String brancos = " ";
			String complemento = servidor.getComplemento() + brancos;

			servidor.setComplemento(complemento);
		}

		// Valida e atualiza tamanho do bairro (Adiciona espaços à direita).
		while (servidor.getBairro().length() < 25) {
			String brancos = " ";
			String bairro = servidor.getBairro() + brancos;

			servidor.setBairro(bairro);
		}

		// Valida e atualiza tamanho do município (Adiciona espaços à direita).
		while (servidor.getMunicipio().length() < 30) {
			String brancos = " ";
			String municipio = servidor.getMunicipio() + brancos;

			servidor.setMunicipio(municipio);
		}

		// Valida e atualiza tamanho do RG (Adiciona espaços à direita).
		while (servidor.getRg().length() < 14) {
			String brancos = " ";
			String rg = servidor.getRg() + brancos;

			servidor.setRg(rg);
		}

		// Valida e atualiza tamanho do órgão expedidor do RG (Adiciona espaços à
		// direita).
		while (servidor.getOrgaoExpedidor().length() < 5) {
			String brancos = " ";
			String orgaoExpedidor = servidor.getOrgaoExpedidor() + brancos;

			servidor.setOrgaoExpedidor(orgaoExpedidor);
		}

		// Valida e atualiza tamanho do título do eleitor (Adiciona zeros à esquerda).
		while (servidor.getTituloEleitor().length() < 13) {
			String zeros = "0";
			String tituloEleitor = zeros + servidor.getTituloEleitor();

			servidor.setTituloEleitor(tituloEleitor);
		}

		// Valida e atualiza tamanho do Filler4 (Adiciona zeros à direita).
		while (servidor.getFiller4().length() < 395) {
			String brancos = " ";
			String filler4 = servidor.getFiller4() + brancos;

			servidor.setFiller4(filler4);
		}

		// Valida e atualiza tamanho do Agência Bancária (Adiciona espaços à
		// esquerda).
		while (servidor.getAgencia().length() < 6) {
			String zeros = "0";
			String agencia = zeros + servidor.getAgencia();

			servidor.setAgencia(agencia);
		}


		// Valida e atualiza tamanho da conta bancária (Adiciona espaços à esquerda).
		while (servidor.getContaBancaria().length() < 13) {
			String zeros = "0";
			String contaBancaria = zeros + servidor.getContaBancaria();

			servidor.setContaBancaria(contaBancaria);
		}

		// Valida e atualiza data de desligamento do servidor (Adiciona zeros à
		// esquerda).
		while (servidor.getDataSaida().length() < 8) {
			String zeros = "0";
			String dataSaida = zeros + servidor.getDataSaida();

			servidor.setDataSaida(dataSaida);
		}

		// Valida e atualiza unidade de lotação do servidor (Adiciona zeros à
		// esquerda).
		while (servidor.getUnidadeLotacao().length() < 9) {
			String zeros = "0";
			String unidadeLotacao = zeros + servidor.getUnidadeLotacao();

			servidor.setUnidadeLotacao(unidadeLotacao);
		}

	}

	public void validateQtdServidores(FitaEspelho fita) {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		while (fita.getQtdServidores().length() < 9) {
			String zeros = "0";
			String codigo = zeros + fita.getQtdServidores();

			fita.setQtdServidores(codigo);
		}

	}

	public static String completarCaracteresEsquerda(String originalString, int tamanhoFinalString, String caractere,
			boolean tirarEspa�os) {

		String temp = "";
		if (tirarEspa�os) {
			temp = originalString.trim().replaceAll("\\s+", "");
		} else {
			temp = originalString.trim();
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

}
