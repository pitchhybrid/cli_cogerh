package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioSintetico extends Relatorio {
	
	 private Integer status;
	 
	 private Integer numeroDiaria;
	 
	 private String solicitante;
	 
	 private String cargo;
	 
	 private Date dataInicioPrevisto;
	 
	 private Date dataFimPrevisto;
	 
	 private String localidadeOrigem;
	 
	 private String localidadeDestino;
	 
	 private String justificativaSolicitacao;
	 
	 private Double qtdDiarias;
	 
	 private Double valorDiaria;
	 
	 private Double valorTotalPrevisto;
	 
	 private String matriculaFuncionario;
	 
	 private Date dataInclusao;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getJustificativaSolicitacao() {
		return justificativaSolicitacao;
	}

	public void setJustificativaSolicitacao(String justificativaSolicitacao) {
		this.justificativaSolicitacao = justificativaSolicitacao;
	}

	public Double getQtdDiarias() {
		return qtdDiarias;
	}

	public void setQtdDiarias(Double qtdDiarias) {
		this.qtdDiarias = qtdDiarias;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorTotalPrevisto() {
		return valorTotalPrevisto;
	}

	public void setValorTotalPrevisto(Double valorTotalPrevisto) {
		this.valorTotalPrevisto = valorTotalPrevisto;
	}

	public String getMatriculaFuncionario() {
		return matriculaFuncionario;
	}

	public void setMatriculaFuncionario(String matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	 
	 
	 
	 

}
