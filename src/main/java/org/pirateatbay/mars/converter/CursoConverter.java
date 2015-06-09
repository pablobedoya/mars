package org.pirateatbay.mars.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.pirateatbay.mars.dao.CursoDAO;
import org.pirateatbay.mars.model.Curso;

@FacesConverter(forClass = Curso.class, value = "CursoConverter")
public class CursoConverter implements Converter {
	
	private CursoDAO cursoDAO = new CursoDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return cursoDAO.find(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Curso curso = (Curso) value;
		try {
			return String.valueOf(curso.getIdCurso());
		} catch (Exception e) {
			return null;
		}
	}
	
}
