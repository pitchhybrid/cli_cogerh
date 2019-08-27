package br.com.cogerh.template.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import org.springframework.stereotype.Service;

import br.com.cogerh.template.relatorios.Relatorio;
import br.com.cogerh.template.service.RelatorioService;

@Service
public class RelatorioServiceImpl implements RelatorioService{
	
	List<Relatorio> relatorio;
	Map<String, Object> param;

	public void gerarRelatorioEmPdf(String origem, String destino) throws JRException {
		JasperReport jasper = JasperCompileManager.compileReport(origem);
		JRBeanCollectionDataSource fonteDadosBean = new JRBeanCollectionDataSource(relatorio, false);
		JasperPrint print = JasperFillManager.fillReport(jasper, param,fonteDadosBean);
		JasperExportManager.exportReportToPdfFile(print, destino);
	}
	
	public void gerarRelatorioEmExcel(String origem, String destino) throws JRException {
		JasperReport jasper = JasperCompileManager.compileReport(origem);
		JRBeanCollectionDataSource fonteDadosBean = new JRBeanCollectionDataSource(relatorio, false);
		JasperPrint print = JasperFillManager.fillReport(jasper, param, fonteDadosBean);
		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(print));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destino));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setWhitePageBackground(false);
		exporter.setConfiguration(configuration);
		exporter.exportReport();
	}
}
