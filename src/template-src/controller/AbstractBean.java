package br.com.cogerh.template.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import br.com.cogerh.template.util.HasValue;

/**
 * Bean utilizado para auxiliar os outros beans da aplicacao
 */
public abstract class AbstractBean implements Serializable {
	
	protected ViewState viewState;

	public void adicionaMensagemDeErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		getContext().addMessage(null, facesMessage);
	}

	public void adicionaMensagemDeSucesso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		getContext().addMessage(null, facesMessage);
	}

	public void adicionaMensagemDeAviso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, mensagem, mensagem);
		getContext().addMessage(null, facesMessage);
	}

	public FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();

		return context;
	}

	/**
	 * Enum para controle do estado de execucao da tela
	 */
	protected enum ViewState {
		NOVO, LISTA, SALVAR, EDITAR, DELETAR, ATUALIZAR;
	}

	public ViewState getViewState() {
		return viewState;
	}

	/**
	 * 
	 * @param caminho
	 * @return o caminho real para um arquivo
	 */

	public String getRealPath(final String caminho) {
		final ServletContext request = (ServletContext) getContext()
				.getExternalContext().getContext();
		final String requestContextPath = request.getRealPath("/");
		final String path = requestContextPath + caminho;
		return path;
	}

	public static String getCampoMessage(String campo) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle resource = ResourceBundle.getBundle(
				"br.com.cogerh.template.resources.messages", context
						.getViewRoot().getLocale());
		return resource.getString(campo);

	}

	public boolean regraDiariaInicialFinal(Integer diariaInicial,
			Integer diariaFinal) {
		if (HasValue.execute(diariaInicial) && HasValue.execute(diariaFinal)) {
			if (diariaInicial > diariaFinal) {
				adicionaMensagemDeErro(getCampoMessage("validacao.numerodiaria"));
				return false;
			}
		}
		return true;
	}

	public boolean regraMatriculaInicialFinal(Integer matriculaInicial,
			Integer matriculaFinal) {
		if (HasValue.execute(matriculaInicial)
				&& HasValue.execute(matriculaFinal)) {
			if (matriculaInicial > matriculaFinal) {
				adicionaMensagemDeErro(getCampoMessage("validacao.matriculadiaria"));
				return false;
			}
		}
		return true;
	}


	public boolean regraQuantidadeNegativa(Integer quantidadeDias) {
		if (quantidadeDias < 0) {
			adicionaMensagemDeErro(getCampoMessage("validacao.data"));
			return false;
		}
		return true;
	}

	public Integer calcularQuantidadeDiasDiaria(Date dataInicial, Date dataFinal) {
		if (HasValue.execute(dataInicial) && HasValue.execute(dataFinal)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dataDe = sdf.parse(sdf.format(dataInicial));
				Date dataAte = sdf.parse(sdf.format(dataFinal));
				return (int) ((dataAte.getTime() - dataDe.getTime()) / (1000 * 60 * 60 * 24));

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

}