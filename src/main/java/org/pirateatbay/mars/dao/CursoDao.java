package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Curso;

public class CursoDao extends GenericDao<Curso> {
	
	private static final long serialVersionUID = 1L;
	
	public CursoDao() {
		setClazz(Curso.class);
	}
	
}
