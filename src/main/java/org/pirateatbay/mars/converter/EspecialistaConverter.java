package org.pirateatbay.mars.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.pirateatbay.mars.dao.EspecialistaDAO;
import org.pirateatbay.mars.model.Especialista;

@FacesConverter(forClass = Especialista.class, value = "EspecialistaConverter")
public class EspecialistaConverter implements Converter {
	
	private EspecialistaDAO especialistaDAO = new EspecialistaDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return especialistaDAO.find(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Especialista especialista = (Especialista) value;
		try {
			return String.valueOf(especialista.getIdEspecialista());
		} catch (Exception e) {
			return null;
		}
	}
	
}
