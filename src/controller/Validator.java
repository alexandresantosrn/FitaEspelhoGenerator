package controller;

import model.FitaEspelho;

public class Validator {

	public void validate(FitaEspelho fita) {

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

	}

}
