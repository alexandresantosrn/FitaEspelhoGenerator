package controller;

import model.FitaEspelho;
import model.Servidor;

public class Validator {

	public void validateDadosInstitucionais(FitaEspelho fita) {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		while (fita.getCodigo().length() < 5) {
			String zeros = "0";
			String codigo = zeros + fita.getCodigo();

			fita.setCodigo(codigo);
		}

		// Valida e atualiza tamanho da Sigla (Adiciona espaços à direita).
		while (fita.getSigla().length() < 10) {
			String brancos = " ";
			String sigla = fita.getSigla() + brancos;

			fita.setSigla(sigla);
		}

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		while (fita.getFiller1().length() < 719) {
			String brancos = " ";
			String filler1 = fita.getFiller1() + brancos;

			fita.setFiller1(filler1);
		}

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		while (fita.getUniPagadora().length() < 9) {
			String zeros = "0";
			String uniPagadora = zeros + fita.getUniPagadora();

			fita.setUniPagadora(uniPagadora);
		}

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

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		while (servidor.getFiller2().length() < 5) {
			String brancos = " ";
			String filler2 = servidor.getFiller2() + brancos;

			servidor.setFiller2(filler2);
		}

		// Valida e atualiza tamanho do Filler1 (Adiciona espaços à direita).
		while (servidor.getFiller3().length() < 25) {
			String zeros = "0";
			String filler3 = servidor.getFiller3() + zeros;

			servidor.setFiller3(filler3);
		}

	}

}
