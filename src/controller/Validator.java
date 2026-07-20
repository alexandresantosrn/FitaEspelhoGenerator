package controller;

import model.FitaEspelhoServidores;
import model.Servidor;
import model.TamanhoCamposFitaServidores;
import model.TamanhoCamposFitaUnidades;
import model.Unidade;
import util.MensagensUtil;

public class Validator {

	public void validateDadosInstitucionais(FitaEspelhoServidores fita) {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		if (fita.getCodigo().length() <= TamanhoCamposFitaServidores.CODIGO) {
			while (fita.getCodigo().length() < TamanhoCamposFitaServidores.CODIGO) {
				String zeros = "0";
				String codigo = zeros + fita.getCodigo();

				fita.setCodigo(codigo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Código da instituição ultrapassa o limite máximo de "
					+ TamanhoCamposFitaServidores.CODIGO + " caracteres.");
		}

		// Valida e atualiza tamanho da sigla (Adiciona espaços à direita).
		if (fita.getSigla().length() <= TamanhoCamposFitaServidores.SIGLA) {
			while (fita.getSigla().length() < 10) {
				String brancos = " ";
				String sigla = fita.getSigla() + brancos;

				fita.setSigla(sigla);
			}
		} else {
			MensagensUtil.errosValidacao.add("Sigla da instituição ultrapassa o limite máximo de "
					+ TamanhoCamposFitaServidores.SIGLA + " caracteres.");
		}

		// Valida e atualiza tamanho do mês (Adiciona zeros à esquerda).
		if (fita.getMes().length() <= TamanhoCamposFitaServidores.MES) {
			while (fita.getMes().length() < 2) {
				String zeros = "0";
				String mes = zeros + fita.getMes();

				fita.setMes(mes);
			}
		} else {
			MensagensUtil.errosValidacao.add(
					"Mês informado ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.MES + " caracteres.");
		}

		// Valida tamanho do ano.
		if (fita.getAno().length() != TamanhoCamposFitaServidores.ANO) {
			MensagensUtil.errosValidacao.add("Ano informado com tamanho de caracteres inválido. O campo deve ter "
					+ TamanhoCamposFitaServidores.MES + " caracteres.");
		}

		// Valida e atualiza tamanho da unidade pagadora (Adiciona zeros à esquerda).
		if (fita.getUniPagadora().length() <= TamanhoCamposFitaServidores.UNIDADE_PAGADORA) {
			while (fita.getUniPagadora().length() < TamanhoCamposFitaServidores.UNIDADE_PAGADORA) {
				String zeros = "0";
				String uniPagadora = zeros + fita.getUniPagadora();

				fita.setUniPagadora(uniPagadora);
			}
		} else {
			MensagensUtil.errosValidacao.add("Tamanho da unidade pagadora ultrapassa o limite máximo de "
					+ TamanhoCamposFitaServidores.UNIDADE_PAGADORA + " caracteres.");
		}

		// Atualiza tamanho do Filler1 (Adiciona espaços à direita).
		while (fita.getFiller1().length() < TamanhoCamposFitaServidores.FILLER1) {
			String brancos = " ";
			String filler1 = fita.getFiller1() + brancos;

			fita.setFiller1(filler1);
		}

		// Atualiza tamanho do Filler final (Adiciona espaços à direita).
		while (fita.getFillerFim().length() < TamanhoCamposFitaServidores.FILLER_FIM) {
			String brancos = " ";
			String fillerFim = fita.getFillerFim() + brancos;

			fita.setFillerFim(fillerFim);
		}

	}

	public void validateDadosPessoais(Servidor servidor) {

		// Valida e atualiza matrícula SIAPE do servidor (Adiciona zeros à esquerda).
		while (servidor.getSiape().length() < 7) {
			String zeros = "0";
			String siape = zeros + servidor.getSiape();

			servidor.setSiape(siape);
		}

		// Valida e atualiza o nome do servidor (Adiciona espaços à direita).
		while (servidor.getNome().length() < 60) {
			String brancos = " ";
			String nome = servidor.getNome() + brancos;

			servidor.setNome(nome);
		}

		// Valida e atualiza o nome da mãe do servidor (Adiciona espaços à direita).
		while (servidor.getNomeMae().length() < 50) {
			String brancos = " ";
			String nomeMae = servidor.getNomeMae() + brancos;

			servidor.setNomeMae(nomeMae);
		}

		// Valida e atualiza tamanho do Filler2 (Adiciona espaços à direita).
		while (servidor.getFiller2().length() < 5) {
			String brancos = " ";
			String filler2 = servidor.getFiller2() + brancos;

			servidor.setFiller2(filler2);
		}

		// Valida e atualiza tamanho do Filler3 (Adiciona zeros à direita).
		while (servidor.getFiller3().length() < 24) {
			String zeros = "0";
			String filler3 = servidor.getFiller3() + zeros;

			servidor.setFiller3(filler3);
		}

		// Valida e atualiza tamanho do Endereço (Adiciona espaços à direita).
		while (servidor.getEndereco().length() < 40) {
			String brancos = " ";
			String endereco = servidor.getEndereco() + brancos;

			servidor.setEndereco(endereco);
		}

		// Valida e atualiza tamanho do número (Adiciona espaços à direita).
		while (servidor.getNumero().length() < 6) {
			String brancos = " ";
			String numero = servidor.getNumero() + brancos;

			servidor.setNumero(numero);
		}

		// Valida e atualiza tamanho do complemento (Adiciona espaços à direita).
		while (servidor.getComplemento().length() < 21) {
			String brancos = " ";
			String complemento = servidor.getComplemento() + brancos;

			servidor.setComplemento(complemento);
		}

		// Valida e atualiza tamanho do bairro (Adiciona espaços à direita).
		while (servidor.getBairro().length() < 25) {
			String brancos = " ";
			String bairro = servidor.getBairro() + brancos;

			servidor.setBairro(bairro);
		}

		// Valida e atualiza tamanho do município (Adiciona espaços à direita).
		while (servidor.getMunicipio().length() < 30) {
			String brancos = " ";
			String municipio = servidor.getMunicipio() + brancos;

			servidor.setMunicipio(municipio);
		}

		// Valida e atualiza tamanho do RG (Adiciona espaços à direita).
		while (servidor.getRg().length() < 14) {
			String brancos = " ";
			String rg = servidor.getRg() + brancos;

			servidor.setRg(rg);
		}

		// Valida e atualiza tamanho do órgão expedidor do RG (Adiciona espaços à
		// direita).
		while (servidor.getOrgaoExpedidor().length() < 5) {
			String brancos = " ";
			String orgaoExpedidor = servidor.getOrgaoExpedidor() + brancos;

			servidor.setOrgaoExpedidor(orgaoExpedidor);
		}

		// Valida e atualiza tamanho do título do eleitor (Adiciona zeros à esquerda).
		while (servidor.getTituloEleitor().length() < 13) {
			String zeros = "0";
			String tituloEleitor = zeros + servidor.getTituloEleitor();

			servidor.setTituloEleitor(tituloEleitor);
		}

		// Valida e atualiza tamanho do Filler4 (Adiciona zeros à direita).
		while (servidor.getFiller4().length() < 395) {
			String brancos = " ";
			String filler4 = servidor.getFiller4() + brancos;

			servidor.setFiller4(filler4);
		}

		// Valida e atualiza tamanho do banco (Adiciona zeros à esquerda).
		if (servidor.getBanco().length() <= TamanhoCamposFitaServidores.BANCO) {
			while (servidor.getBanco().length() < TamanhoCamposFitaServidores.BANCO) {
				String zeros = "0";
				String banco = zeros + servidor.getBanco();

				servidor.setBanco(banco);
			}
		} else {
			MensagensUtil.errosValidacao.add("Banco do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.BANCO + " caracteres.");
		}

		// Valida e atualiza tamanho do Agência Bancária (Adiciona espaços à direita).
		if (servidor.getAgencia().length() <= TamanhoCamposFitaServidores.AGENCIA_BANCARIA) {
			while (servidor.getAgencia().length() < TamanhoCamposFitaServidores.AGENCIA_BANCARIA) {
				String brancos = " ";
				String agencia = brancos + servidor.getAgencia();

				servidor.setAgencia(agencia);
			}
		} else {
			MensagensUtil.errosValidacao.add("Agência bancária do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.AGENCIA_BANCARIA + " caracteres.");
		}

		// Valida e atualiza tamanho da conta bancária (Adiciona espaços à esquerda).
		if (servidor.getContaBancaria().length() <= TamanhoCamposFitaServidores.CONTA_BANCARIA) {
			while (servidor.getContaBancaria().length() < TamanhoCamposFitaServidores.CONTA_BANCARIA) {
				String brancos = " ";
				String contaBancaria = brancos + servidor.getContaBancaria();

				servidor.setContaBancaria(contaBancaria);
			}
		} else {
			MensagensUtil.errosValidacao.add("Conta bancária do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.CONTA_BANCARIA + " caracteres.");
		}

		// Valida e atualiza data de desligamento do servidor (Adiciona zeros à
		// esquerda).
		while (servidor.getDataSaida().length() < 8) {
			String zeros = "0";
			String dataSaida = zeros + servidor.getDataSaida();

			servidor.setDataSaida(dataSaida);
		}

		// Valida e atualiza unidade de lotação do servidor (Adiciona zeros à
		// esquerda).
		while (servidor.getUnidadeLotacao().length() < 9) {
			String zeros = "0";
			String unidadeLotacao = zeros + servidor.getUnidadeLotacao();

			servidor.setUnidadeLotacao(unidadeLotacao);
		}

	}

	public void validateDadosFuncionais(Servidor servidor) {

		// Valida e atualiza o grupo cargo do servidor (Adiciona zeros à esquerda).
		if (servidor.getGrupoCargo().length() <= TamanhoCamposFitaServidores.GRUPO_CARGO) {
			while (servidor.getGrupoCargo().length() < TamanhoCamposFitaServidores.GRUPO_CARGO) {
				String zeros = "0";
				String grupoCargo = zeros + servidor.getGrupoCargo();

				servidor.setGrupoCargo(grupoCargo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Grupo Cargo do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.GRUPO_CARGO + " caracteres.");
		}

		// Valida e atualiza o cargo do servidor (Adiciona zeros à esquerda).
		if (servidor.getCargo().length() <= TamanhoCamposFitaServidores.CARGO) {
			while (servidor.getCargo().length() < TamanhoCamposFitaServidores.CARGO) {
				String zeros = "0";
				String cargo = zeros + servidor.getCargo();

				servidor.setCargo(cargo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Cargo do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.CARGO + " caracteres.");
		}

		// Valida e atualiza a classe funcional do servidor (Adiciona espaços à
		// direita).
		if (servidor.getClasseCargo().length() <= TamanhoCamposFitaServidores.CLASSE_CARGO) {
			while (servidor.getClasseCargo().length() < TamanhoCamposFitaServidores.CLASSE_CARGO) {
				String brancos = " ";
				String classeCargo = servidor.getClasseCargo() + brancos;

				servidor.setClasseCargo(classeCargo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Classe funcional do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.CLASSE_CARGO + " caracteres.");
		}

		// Valida e atualiza a classe funcional do servidor (Adiciona espaços à
		// direita).
		if (servidor.getNivelCargo().length() <= TamanhoCamposFitaServidores.NIVEL_CARGO) {
			while (servidor.getNivelCargo().length() < TamanhoCamposFitaServidores.NIVEL_CARGO) {
				String brancos = " ";
				String nivelCargo = servidor.getNivelCargo() + brancos;

				servidor.setNivelCargo(nivelCargo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Nivel funcional do servidor: " + servidor.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaServidores.NIVEL_CARGO + " caracteres.");
		}
	}

	public void validateQtdServidores(FitaEspelhoServidores fita) {

		// Valida e atualiza tamanho do código (Adiciona zeros à esquerda).
		while (fita.getQtdServidores().length() < 9) {
			String zeros = "0";
			String codigo = zeros + fita.getQtdServidores();

			fita.setQtdServidores(codigo);
		}

	}

	public void validateUnidades(Unidade unidade) {
		// Valida e atualiza tamanho do código de identificação da unidade (Adiciona
		// zeros à esquerda).
		if (unidade.getIdUnidade().length() <= TamanhoCamposFitaUnidades.ID_UNIDADE) {
			while (unidade.getIdUnidade().length() < TamanhoCamposFitaUnidades.ID_UNIDADE) {
				String zeros = "0";
				String codigo = zeros + unidade.getIdUnidade();

				unidade.setIdUnidade(codigo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Código da identificação da unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.ID_UNIDADE + " caracteres.");
		}

		// Valida e atualiza o nome da unidade (Adiciona espaços à direita).
		if (unidade.getNome().length() <= TamanhoCamposFitaUnidades.NOME_UNIDADE) {
			while (unidade.getNome().length() < TamanhoCamposFitaUnidades.NOME_UNIDADE) {
				String brancos = " ";
				String nome = unidade.getNome() + brancos;

				unidade.setNome(nome);
			}
		} else {
			MensagensUtil.errosValidacao.add("Nome da unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.NOME_UNIDADE + " caracteres.");
		}

		// Valida e atualiza o nome da unidade (Adiciona espaços à direita).
		if (unidade.getSigla().length() <= TamanhoCamposFitaUnidades.SIGLA_UNIDADE) {
			while (unidade.getSigla().length() < TamanhoCamposFitaUnidades.SIGLA_UNIDADE) {
				String brancos = " ";
				String sigla = unidade.getSigla() + brancos;

				unidade.setSigla(sigla);
			}
		} else {
			MensagensUtil.errosValidacao.add("Sigla da unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.SIGLA_UNIDADE + " caracteres.");
		}

		// Valida e atualiza sigla da UF (Adiciona espaços à direita).
		if (unidade.getUf().length() <= TamanhoCamposFitaUnidades.UF_UNIDADE) {
			while (unidade.getUf().length() < TamanhoCamposFitaUnidades.UF_UNIDADE) {
				String brancos = " ";
				String uf = unidade.getUf() + brancos;

				unidade.setUf(uf);
			}
		} else {
			MensagensUtil.errosValidacao.add("Sigla da UF unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.UF_UNIDADE + " caracteres.");
		}

		// Valida e atualiza tamanho do código da unidade pagadora (Adiciona zeros à
		// esquerda).
		if (unidade.getIdUnidadePagadora().length() <= TamanhoCamposFitaUnidades.ID_UNIDADE_PAGADORA) {
			while (unidade.getIdUnidadePagadora().length() < TamanhoCamposFitaUnidades.ID_UNIDADE_PAGADORA) {
				String zeros = "0";
				String codigo = zeros + unidade.getIdUnidadePagadora();

				unidade.setIdUnidadePagadora(codigo);
			}
		} else {
			MensagensUtil.errosValidacao
					.add("Unidade pagadora da unidade: " + unidade.getNome() + " " + "ultrapassa o limite máximo de "
							+ TamanhoCamposFitaUnidades.ID_UNIDADE_PAGADORA + " caracteres.");
		}

		// Valida e atualiza tamanho do código da unidade gestora (Adiciona zeros à
		// esquerda).
		if (unidade.getUnidadeGestora().length() <= TamanhoCamposFitaUnidades.UNIDADE_GESTORA) {
			while (unidade.getUnidadeGestora().length() < TamanhoCamposFitaUnidades.UNIDADE_GESTORA) {
				String zeros = "0";
				String codigo = zeros + unidade.getUnidadeGestora();

				unidade.setUnidadeGestora(codigo);
			}
		} else {
			MensagensUtil.errosValidacao.add("Unidade gestora da unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.UNIDADE_GESTORA + " caracteres.");
		}

		// Valida e atualiza unidade antecedentes (Adiciona espaços à direita).
		if (unidade.getUnidadeAntecedente().length() <= TamanhoCamposFitaUnidades.UNIDADE_ANTECEDENTE) {
			while (unidade.getUnidadeAntecedente().length() < TamanhoCamposFitaUnidades.UNIDADE_ANTECEDENTE) {
				String brancos = " ";
				String antecedente = unidade.getUnidadeAntecedente() + brancos;

				unidade.setUnidadeAntecedente(antecedente);
			}
		} else {
			MensagensUtil.errosValidacao.add("Unidade antecedente da unidade: " + unidade.getNome() + " "
					+ "ultrapassa o limite máximo de " + TamanhoCamposFitaUnidades.UF_UNIDADE + " caracteres.");
		}

	}

}
