package br.com.cogerh.template.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "StatusConverter")
public class StatusConverter implements Converter {

	/**
	 * Retorna o objeto .
	 * 
	 * @param context
	 *            FacesContext.
	 * @param comp
	 *            UIComponent.
	 * @param value
	 *            Valor.
	 * 
	 * @return 
	 */
	public Object getAsObject(final FacesContext context,
			final UIComponent comp, final String value) {
		Boolean object = null;
		return object;
	}

	/**
	 * Retorna o Status no formato de descri��o.
	 * 
	 * @param context
	 *            FacesContext.
	 * @param comp
	 *            UIComponent.
	 * @param object
	 *            Objeto.
	 * 
	 * @return String Ativo/Inativo.
	 */
	public String getAsString(final FacesContext context,
			final UIComponent comp, final Object object) {
		String value = "Status N�o Encontrado";
		try {
			if (object != null) {
				Integer retorno = 0;
				if (object instanceof java.lang.Integer) {
					retorno = (Integer) object;
					if (retorno.intValue() == 1) {
						value = "Di�ria aguardando aprova��o n�vel 01";
					} else
					if (retorno.intValue() == 2) {
						value = "Di�ria aguardando aprova��o n�vel 02";
					} else
					if (retorno.intValue() == 3) {
						value = "Di�ria aguardando presta��es de contas";
					} else
					if (retorno.intValue() == 4) {
						value = "Di�ria rejeitada";
					} else
					if (retorno.intValue() == 5) {
						value = "Di�ria encerrada n�o realizada";
					} else 
					if (retorno.intValue() == 6) {
						value = "Di�ria encerrada e realizada";
					}
				} 
			}
		} catch (Exception e) {
			throw new ConverterException(e);
		}
		return value;
	}
}

