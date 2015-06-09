package org.pirateatbay.mars.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.pirateatbay.mars.dao.PoloDao;
import org.pirateatbay.mars.model.Polo;

@FacesConverter(forClass = Polo.class, value = "PoloConverter")
public class PoloConverter implements Converter {
	
	private PoloDao poloDao = new PoloDao();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return poloDao.find(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Polo polo = (Polo) value;
		try {
			return String.valueOf(polo.getIdPolo());
		} catch (Exception e) {
			return null;
		}
	}
	
}
