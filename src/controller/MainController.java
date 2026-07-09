package controller;

import java.io.IOException;
import java.util.List;

import util.MensagensUtil;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregarServidores() throws IOException, InterruptedException {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();
		
		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoServidores();
		} else {
			for (String erro : MensagensUtil.errosValidacao) {
				System.out.println("\n");
				System.out.println("******** Erro: " + erro + " ********");
			}
		}
	}

}
