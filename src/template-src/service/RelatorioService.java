package br.com.cogerh.template.service;

import net.sf.jasperreports.engine.JRException;

public interface RelatorioService {
	
	public void gerarRelatorioEmPdf(String origem, String destino)
			throws JRException;
	
	public void gerarRelatorioEmExcel(String origem, String destino)
			throws JRException;
}
