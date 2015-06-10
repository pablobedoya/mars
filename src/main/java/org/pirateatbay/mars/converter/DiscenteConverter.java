package org.pirateatbay.mars.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.pirateatbay.mars.dao.DiscenteDAO;
import org.pirateatbay.mars.model.Discente;

@FacesConverter(forClass = Discente.class, value = "DiscenteConverter")
public class DiscenteConverter implements Converter {
	
	private DiscenteDAO discenteDAO = new DiscenteDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return discenteDAO.find(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Discente discente = (Discente) value;
		try {
			return String.valueOf(discente.getIdDiscente());
		} catch (Exception e) {
			return null;
		}
	}
	
}
