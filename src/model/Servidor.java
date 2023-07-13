package model;

public class Servidor {

	String siape, digitoSIAPE, nome, cpf, pis, nomeMae, sexo, dataNascimento, estadoCivil, escolaridade, codigoFormacao,
			nacionalidade, siglaNaturalidade, endereco, numero, complemento, bairro, municipio, cep, uf, rg,
			orgaoExpedidor, dataExpedicao, ufIdentidade, tituloEleitor, siglaRegime, situacaoServidor, banco, agencia,
			contaBancaria, jornada, dataCadastro, grupoCargo, cargo, classeCargo, nivelCargo, dataEntrada, dataSaida,
			unidadeLotacao, dataIngressoUnidade, admissaoOrgao, admissaoServicoPublico;

	String filler2 = " ";
	String filler3 = "0";
	String filler4 = "00000";
	int linhaArquivo = 0;
	
	public int getLinhaArquivo() {
		return linhaArquivo;
	}

	public void setLinhaArquivo(int linhaArquivo) {
		this.linhaArquivo = linhaArquivo;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getDigitoSIAPE() {
		return digitoSIAPE;
	}

	public void setDigitoSIAPE(String digitoSIAPE) {
		this.digitoSIAPE = digitoSIAPE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getCodigoFormacao() {
		return codigoFormacao;
	}

	public void setCodigoFormacao(String codigoFormacao) {
		this.codigoFormacao = codigoFormacao;
	}

	public String getFiller2() {
		return filler2;
	}

	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getSiglaNaturalidade() {
		return siglaNaturalidade;
	}

	public void setSiglaNaturalidade(String siglaNaturalidade) {
		this.siglaNaturalidade = siglaNaturalidade;
	}

	public String getFiller3() {
		return filler3;
	}

	public void setFiller3(String filler3) {
		this.filler3 = filler3;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getUfIdentidade() {
		return ufIdentidade;
	}

	public void setUfIdentidade(String ufIdentidade) {
		this.ufIdentidade = ufIdentidade;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getFiller4() {
		return filler4;
	}

	public void setFiller4(String filler4) {
		this.filler4 = filler4;
	}

	public String getSiglaRegime() {
		return siglaRegime;
	}

	public void setSiglaRegime(String siglaRegime) {
		this.siglaRegime = siglaRegime;
	}

	public String getSituacaoServidor() {
		return situacaoServidor;
	}

	public void setSituacaoServidor(String situacaoServidor) {
		this.situacaoServidor = situacaoServidor;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(String contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getGrupoCargo() {
		return grupoCargo;
	}

	public void setGrupoCargo(String grupoCargo) {
		this.grupoCargo = grupoCargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getClasseCargo() {
		return classeCargo;
	}

	public void setClasseCargo(String classeCargo) {
		this.classeCargo = classeCargo;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getUnidadeLotacao() {
		return unidadeLotacao;
	}

	public void setUnidadeLotacao(String unidadeLotacao) {
		this.unidadeLotacao = unidadeLotacao;
	}

	public String getDataIngressoUnidade() {
		return dataIngressoUnidade;
	}

	public void setDataIngressoUnidade(String dataIngressoUnidade) {
		this.dataIngressoUnidade = dataIngressoUnidade;
	}

	public String getAdmissaoOrgao() {
		return admissaoOrgao;
	}

	public void setAdmissaoOrgao(String admissaoOrgao) {
		this.admissaoOrgao = admissaoOrgao;
	}

	public String getAdmissaoServicoPublico() {
		return admissaoServicoPublico;
	}

	public void setAdmissaoServicoPublico(String admissaoServicoPublico) {
		this.admissaoServicoPublico = admissaoServicoPublico;
	}

}
