package model;

import java.util.ArrayList;
import java.util.List;

public class FitaEspelho {

	final String constante = "000000000000000000";
	final String nome = "SIAPEFITAESP";
	String filler1 = " ";
	String codigo, sigla, mes, ano, uniPagadora, uf;
	String fillerFim = " ";
	String qtdServidores;

	List<Servidor> servidores = new ArrayList<>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getConstante() {
		return constante;
	}

	public String getNome() {
		return nome;
	}

	public String getFiller1() {
		return filler1;
	}

	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}

	public String getUniPagadora() {
		return uniPagadora;
	}

	public void setUniPagadora(String uniPagadora) {
		this.uniPagadora = uniPagadora;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void addServidores(Servidor servidor) {
		servidores.add(servidor);
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFillerFim() {
		return fillerFim;
	}

	public void setFillerFim(String fillerFim) {
		this.fillerFim = fillerFim;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}

	public String getQtdServidores() {
		return qtdServidores;
	}

	public void setQtdServidores(String codigo2) {
		this.qtdServidores = codigo2;
	}
	
	public void printCabecalho() {
		System.out.println("\nCabeçalho Fita Espelho \nCódigo : " + codigo + ", Sigla : " + sigla +", Mês : "+ mes 
				+ ", Ano : " + ano + ", UniPagadora : " + uniPagadora + ", UF : " + uf + "\n");		
	}

}
