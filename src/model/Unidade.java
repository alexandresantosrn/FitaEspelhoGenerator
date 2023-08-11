package model;

public class Unidade {
 
	String idUnidade, nome, sigla, uf, idUnidadePagadora, unidadeGestora, unidadeAntecedente;
	int linhaArquivo = 0;
	
	public int getLinhaArquivo() {
		return linhaArquivo;
	}

	public void setLinhaArquivo(int linhaArquivo) {
		this.linhaArquivo = linhaArquivo;
	}

	public String getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(String idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIdUnidadePagadora() {
		return idUnidadePagadora;
	}

	public void setIdUnidadePagadora(String idUnidadePagadora) {
		this.idUnidadePagadora = idUnidadePagadora;
	}

	public String getUnidadeGestora() {
		return unidadeGestora;
	}

	public void setUnidadeGestora(String unidadeGestora) {
		this.unidadeGestora = unidadeGestora;
	}

	public String getUnidadeAntecedente() {
		return unidadeAntecedente;
	}

	public void setUnidadeAntecedente(String unidadeAntecedente) {
		this.unidadeAntecedente = unidadeAntecedente;
	}

	@Override
	public String toString() {
		return "Unidade [idUnidade=" + idUnidade + ", nome=" + nome + ", sigla=" + sigla + ", uf=" + uf
				+ ", idUnidadePagadora=" + idUnidadePagadora + ", unidadeGestora=" + unidadeGestora
				+ ", unidadeAntecedente=" + unidadeAntecedente + ", linhaArquivo=" + linhaArquivo + "]";
	}
	
}
