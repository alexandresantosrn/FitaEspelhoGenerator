package controller;

import java.io.IOException;

import view.Mensagens;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregar() throws IOException, Exception {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();
		if (Mensagens.errosValidacao.isEmpty()) {
			controlador.exportarArquivo();
		}
	}

}
