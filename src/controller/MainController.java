package controller;

import java.io.IOException;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregar() throws IOException, Exception {		
			controlador.informarDadosInstituicao();
			controlador.carregarDadosServidores();
			controlador.exportarArquivo();
	}

}
