package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioDiarias extends Relatorio{

	private Date dataEnvio;
	
	private Integer numeroDiaria;
	
	private String solicitante;
	
	private String cargo;
	
	private Date dataInicioPrevisto;
	
	private Date dataFimPrevisto;
	
	private String periodoViagem;
	
	private Double valor;
	
	private String descricaoGerencia;
	
	private Integer diretoria;
	
	private Double qtdDiarias;
	
	private String descricaoMacroprojeto;

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getNumeroDiaria() {
		return numeroDiaria;
	}

	public void setNumeroDiaria(Integer numeroDiaria) {
		this.numeroDiaria = numeroDiaria;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataInicioPrevisto() {
		return dataInicioPrevisto;
	}

	public void setDataInicioPrevisto(Date dataInicioPrevisto) {
		this.dataInicioPrevisto = dataInicioPrevisto;
	}

	public Date getDataFimPrevisto() {
		return dataFimPrevisto;
	}

	public void setDataFimPrevisto(Date dataFimPrevisto) {
		this.dataFimPrevisto = dataFimPrevisto;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricaoGerencia() {
		return descricaoGerencia;
	}

	public void setDescricaoGerencia(String descricaoGerencia) {
		this.descricaoGerencia = descricaoGerencia;
	}

	public Integer getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Integer diretoria) {
		this.diretoria = diretoria;
	}

	public Double getQtdDiarias() {
		return qtdDiarias;
	}

	public void setQtdDiarias(Double qtdDiarias) {
		this.qtdDiarias = qtdDiarias;
	}

	public String getDescricaoMacroprojeto() {
		return descricaoMacroprojeto;
	}

	public void setDescricaoMacroprojeto(String descricaoMacroprojeto) {
		this.descricaoMacroprojeto = descricaoMacroprojeto;
	}

	public String getPeriodoViagem() {
		return periodoViagem;
	}

	public void setPeriodoViagem(String periodoViagem) {
		this.periodoViagem = periodoViagem;
	}
	
}
