package org.pirateatbay.mars.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.pirateatbay.mars.dao.AgendamentoDAO;
import org.pirateatbay.mars.model.Agendamento;

@FacesConverter(forClass = Agendamento.class, value = "AgendamentoConverter")
public class AgendamentoConverter implements Converter {
	
	private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return agendamentoDAO.find(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Agendamento agendamento = (Agendamento) value;
		try {
			return String.valueOf(agendamento.getIdAgendamento());
		} catch (Exception e) {
			return null;
		}
	}
	
}
