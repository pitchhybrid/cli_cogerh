package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioComplementacaoDevolucao extends Relatorio {

	private Integer diariaId;
	
	private Date dataAtual;

	private Date dataInicioPrevisto;

	private Date dataFimPrevisto;

	private Date dataInicioReal;

	private Date dataFimReal;

	private Double quantidadePrevista;

	private Double quantidadeReal;

	private Double valorReal;

	private Double valorPrevisto;

	private Double valorDiaria;

	private Double valorDevolver;

	private Double valorComplementar;
	

	public Integer getDiariaId() {
		return diariaId;
	}

	public void setDiariaId(Integer diariaId) {
		this.diariaId = diariaId;
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

	public Date getDataInicioReal() {
		return dataInicioReal;
	}

	public void setDataInicioReal(Date dataInicioReal) {
		this.dataInicioReal = dataInicioReal;
	}

	public Date getDataFimReal() {
		return dataFimReal;
	}

	public void setDataFimReal(Date dataFimReal) {
		this.dataFimReal = dataFimReal;
	}

	public Double getQuantidadePrevista() {
		return quantidadePrevista;
	}

	public void setQuantidadePrevista(Double quantidadePrevista) {
		this.quantidadePrevista = quantidadePrevista;
	}

	public Double getValorReal() {
		return valorReal;
	}

	public void setValorReal(Double valorReal) {
		this.valorReal = valorReal;
	}

	public Double getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(Double valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorDevolver() {
		return valorDevolver;
	}

	public void setValorDevolver(Double valorDevolver) {
		this.valorDevolver = valorDevolver;
	}

	public Double getQuantidadeReal() {
		return quantidadeReal;
	}

	public void setQuantidadeReal(Double quantidadeReal) {
		this.quantidadeReal = quantidadeReal;
	}

	public Double getValorComplementar() {
		return valorComplementar;
	}

	public void setValorComplementar(Double valorComplementar) {
		this.valorComplementar = valorComplementar;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	
	

}
