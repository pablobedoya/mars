package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Curso;

public class CursoDAO extends GenericDAO<Curso> {
	
	private static final long serialVersionUID = 1L;
	
	public CursoDAO() {
		setClazz(Curso.class);
	}
	
}
