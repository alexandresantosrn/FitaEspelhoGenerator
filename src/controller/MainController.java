package controller;

import java.io.IOException;

import util.MensagensUtil;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregarServidores() throws IOException {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();
		
		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoServidores();
		}
	}

}
