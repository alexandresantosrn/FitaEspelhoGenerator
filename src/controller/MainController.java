package controller;

import java.io.IOException;

import Util.MensagensUtil;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregar() throws IOException, Exception {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();
		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivo();
		}
	}

}
