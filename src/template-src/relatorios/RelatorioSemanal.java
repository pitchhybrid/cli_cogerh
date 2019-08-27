package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioSemanal extends Relatorio{
	
	private Integer numeroDiaria;
	
	private String solicitante;
	
	private String matricula;
	
	private Date dataSolicitacao;
	
	private String cargo;
	
	private String localidadeOrigem;
	
	private String localidadeDestino;
	
	private String gerencia;
	
	private Integer status;

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocalidadeOrigem() {
		return localidadeOrigem;
	}

	public void setLocalidadeOrigem(String localidadeOrigem) {
		this.localidadeOrigem = localidadeOrigem;
	}

	public String getLocalidadeDestino() {
		return localidadeDestino;
	}

	public void setLocalidadeDestino(String localidadeDestino) {
		this.localidadeDestino = localidadeDestino;
	}

	public String getGerencia() {
		return gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
