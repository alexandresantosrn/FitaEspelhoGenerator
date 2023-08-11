package controller;

import java.io.IOException;

import Util.MensagensUtil;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregarServidores() throws IOException, Exception {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();
		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoServidores();
		}
	}
	
	public void carregarUnidades() throws IOException, Exception {
		controlador.carregarDadosUnidades();;
		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoUnidades();
		}
	}

}
