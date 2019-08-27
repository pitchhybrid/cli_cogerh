package br.com.cogerh.template.service;

import java.io.InputStream;
import java.util.List;

public interface ClienteFTPService 
{
	public List<String> listar(String diretorio);
	
	public boolean enviar(String dirRemoto, String arqNome, InputStream arqConteudo);
	
	public boolean baixar(String dirRemoto, String remoto, String local);
	
	public InputStream baixar(String dirRemoto, String remoto);
	
	public boolean excluir(String dirRemoto, String remoto);
}
