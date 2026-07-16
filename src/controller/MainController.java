package controller;

import java.io.IOException;
import util.MensagensUtil;

public class MainController {

	GeneralController controlador = new GeneralController();

	public void carregarServidores() throws IOException, InterruptedException {
		controlador.informarDadosInstituicao();
		controlador.carregarDadosServidores();

		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoServidores();
		} else {
			apresentarMsgErroValidacao();
		}
	}

	public void carregarUnidades() throws IOException, Exception {
		controlador.carregarDadosUnidades();

		if (MensagensUtil.errosValidacao.isEmpty()) {
			controlador.exportarArquivoUnidades();
		} else {
			apresentarMsgErroValidacao();
		}
	}

	public void apresentarMsgErroValidacao() {
		for (String erro : MensagensUtil.errosValidacao) {
			System.out.println("\n");
			System.out.println("******** Erro: " + erro + " ********");
		}
	}
}
