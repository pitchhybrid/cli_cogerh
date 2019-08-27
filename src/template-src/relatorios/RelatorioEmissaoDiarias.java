package br.com.cogerh.template.relatorios;

import java.util.Date;

public class RelatorioEmissaoDiarias extends Relatorio {
	
	private String usuarioInclusao;
	
	private String loginInclusao;
	
	private String nomeEmitente;
	
	private String descricaoStatusDiaria;
	
	private Integer status;
	
	private Integer numeroDiaria;
	
	private Date dataInclusao;

	private String solicitante;
	
	private Long codigoCategoria;
	
	private Date dataInicioPrevisto;
	
	private Date dataFimPrevisto;
	
	private Date dataInicioReal;
	
	private Date dataFimReal;
	
	private String descricaoDestino;
	
	private String localidadeOrigem;
	
	private String localidadeDestino;
	
	private String descricaoGerencia;
	
	private String descricaoBacia;
	
	private String descricaoMacroprojeto;
	
	private String justificativaSolicitacao;
	
	private String justificativaAprovacao1;
	
	private String justificativaAprovacao2;
	
	private String justificativaPrestacaoContas;
	
	private Double qtdDiarias;
	
	private Double valorDiaria;
	
	private Double percentualAcrescimo;
	
	private Double valorAcrescimo;
	
	private Double ajudaCusto;
	
	private Double valorAjuste;
	
	private Double valorTotalPrevisto;
	
	private Double valorTotalReal;
	
	private Double valorDevolvido;
	
	private String aprovadorNivel1;
	
	private String aprovadorNivel2;
	
	private Date dataAprovacaoNivel1;
	
	private Date dataAprovacaoNivel2;

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public String getLoginInclusao() {
		return loginInclusao;
	}

	public void setLoginInclusao(String loginInclusao) {
		this.loginInclusao = loginInclusao;
	}

	public String getNomeEmitente() {
		return nomeEmitente;
	}

	public void setNomeEmitente(String nomeEmitente) {
		this.nomeEmitente = nomeEmitente;
	}
	
	public String getDescricaoStatusDiaria() {
		return descricaoStatusDiaria;
	}

	public void setDescricaoStatusDiaria(String descricaoStatusDiaria) {
		this.descricaoStatusDiaria = descricaoStatusDiaria;
	}

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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
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

	public String getDescricaoDestino() {
		return descricaoDestino;
	}

	public void setDescricaoDestino(String descricaoDestino) {
		this.descricaoDestino = descricaoDestino;
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

	public String getDescricaoGerencia() {
		return descricaoGerencia;
	}

	public void setDescricaoGerencia(String descricaoGerencia) {
		this.descricaoGerencia = descricaoGerencia;
	}

	public String getDescricaoBacia() {
		return descricaoBacia;
	}

	public void setDescricaoBacia(String descricaoBacia) {
		this.descricaoBacia = descricaoBacia;
	}

	public String getDescricaoMacroprojeto() {
		return descricaoMacroprojeto;
	}

	public void setDescricaoMacroprojeto(String descricaoMacroprojeto) {
		this.descricaoMacroprojeto = descricaoMacroprojeto;
	}

	public String getJustificativaSolicitacao() {
		return justificativaSolicitacao;
	}

	public void setJustificativaSolicitacao(String justificativaSolicitacao) {
		this.justificativaSolicitacao = justificativaSolicitacao;
	}

	public String getJustificativaAprovacao1() {
		return justificativaAprovacao1;
	}

	public void setJustificativaAprovacao1(String justificativaAprovacao1) {
		this.justificativaAprovacao1 = justificativaAprovacao1;
	}

	public String getJustificativaAprovacao2() {
		return justificativaAprovacao2;
	}

	public void setJustificativaAprovacao2(String justificativaAprovacao2) {
		this.justificativaAprovacao2 = justificativaAprovacao2;
	}

	public String getJustificativaPrestacaoContas() {
		return justificativaPrestacaoContas;
	}

	public void setJustificativaPrestacaoContas(String justificativaPrestacaoContas) {
		this.justificativaPrestacaoContas = justificativaPrestacaoContas;
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

	public Double getPercentualAcrescimo() {
		return percentualAcrescimo;
	}

	public void setPercentualAcrescimo(Double percentualAcrescimo) {
		this.percentualAcrescimo = percentualAcrescimo;
	}

	public Double getValorAcrescimo() {
		return valorAcrescimo;
	}

	public void setValorAcrescimo(Double valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	public Double getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(Double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

	public Double getValorAjuste() {
		return valorAjuste;
	}

	public void setValorAjuste(Double valorAjuste) {
		this.valorAjuste = valorAjuste;
	}

	public Double getValorTotalPrevisto() {
		return valorTotalPrevisto;
	}

	public void setValorTotalPrevisto(Double valorTotalPrevisto) {
		this.valorTotalPrevisto = valorTotalPrevisto;
	}

	public Double getValorTotalReal() {
		return valorTotalReal;
	}

	public void setValorTotalReal(Double valorTotalReal) {
		this.valorTotalReal = valorTotalReal;
	}

	public Double getValorDevolvido() {
		return valorDevolvido;
	}

	public void setValorDevolvido(Double valorDevolvido) {
		this.valorDevolvido = valorDevolvido;
	}

	public String getAprovadorNivel1() {
		return aprovadorNivel1;
	}

	public void setAprovadorNivel1(String aprovadorNivel1) {
		this.aprovadorNivel1 = aprovadorNivel1;
	}

	public String getAprovadorNivel2() {
		return aprovadorNivel2;
	}

	public void setAprovadorNivel2(String aprovadorNivel2) {
		this.aprovadorNivel2 = aprovadorNivel2;
	}

	public Date getDataAprovacaoNivel1() {
		return dataAprovacaoNivel1;
	}

	public void setDataAprovacaoNivel1(Date dataAprovacaoNivel1) {
		this.dataAprovacaoNivel1 = dataAprovacaoNivel1;
	}

	public Date getDataAprovacaoNivel2() {
		return dataAprovacaoNivel2;
	}

	public void setDataAprovacaoNivel2(Date dataAprovacaoNivel2) {
		this.dataAprovacaoNivel2 = dataAprovacaoNivel2;
	}
	
}
