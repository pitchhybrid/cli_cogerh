package br.com.cogerh.template.service;

import java.sql.SQLException;
import java.util.Date;


public interface BusinessInteligenceService {
	public void gerarRelatorio(Date dataInicial, Date dataFinal) throws SQLException;
}
