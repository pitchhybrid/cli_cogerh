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
	 * Retorna o Status no formato de descrição.
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
		String value = "Status Não Encontrado";
		try {
			if (object != null) {
				Integer retorno = 0;
				if (object instanceof java.lang.Integer) {
					retorno = (Integer) object;
					if (retorno.intValue() == 1) {
						value = "Diária aguardando aprovação nível 01";
					} else
					if (retorno.intValue() == 2) {
						value = "Diária aguardando aprovação nível 02";
					} else
					if (retorno.intValue() == 3) {
						value = "Diária aguardando prestações de contas";
					} else
					if (retorno.intValue() == 4) {
						value = "Diária rejeitada";
					} else
					if (retorno.intValue() == 5) {
						value = "Diária encerrada não realizada";
					} else 
					if (retorno.intValue() == 6) {
						value = "Diária encerrada e realizada";
					}
				} 
			}
		} catch (Exception e) {
			throw new ConverterException(e);
		}
		return value;
	}
}

