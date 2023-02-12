package controller;

public class MainController {
	
	GeneralController controlador = new GeneralController();

	public void carregar() {
		
		controlador.informarDadosInstituicao();
		controlador.exportarArquivo();
	}

	

	

}
