package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioDiariasSemDocumentoAcompanhamento extends Relatorio{

	
	private Integer numeroDiaria;
	
	private String solicitante;
	
	private String cargo;
	
	private String descricaoGerencia;
	
	private Double valor;
	
	private Double qtdDiarias;
	
	private Date dataInicioPrevisto;
	
	private Date dataFimPrevisto;
	
	//Getters e Setters

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

	public Double getQtdDiarias() {
		return qtdDiarias;
	}

	public void setQtdDiarias(Double qtdDiarias) {
		this.qtdDiarias = qtdDiarias;
	}	
}
