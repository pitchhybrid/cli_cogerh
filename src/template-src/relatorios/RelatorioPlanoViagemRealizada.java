package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioPlanoViagemRealizada extends Relatorio{
	
	private Integer numeroDiaria;
	
	private String solicitante;
	
	private String matricula;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private String cargo;
	
	private String localidadeOrigem;
	
	private String localidadeDestino;
	
	private Double qtdDiarias;
	
	private Double valorDiaria;
	
	private Double ajudaCusto;
	
	private Double valorTotalReal;
	
	private String banco;
	
	private String agencia;
	
	private String conta;
	
	private String gerencia;

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

	public Double getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(Double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

	public Double getValorTotalReal() {
		return valorTotalReal;
	}

	public void setValorTotalReal(Double valorTotalReal) {
		this.valorTotalReal = valorTotalReal;
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

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getGerencia() {
		return gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}
}
