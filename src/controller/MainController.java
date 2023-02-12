package controller;

import java.io.IOException;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregar() throws IOException {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosPessoaisServidores();
		controlador.exportarArquivo();
	}

}
