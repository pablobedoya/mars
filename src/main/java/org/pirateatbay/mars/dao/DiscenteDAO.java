package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Discente;

public class DiscenteDAO extends GenericDAO<Discente> {
	
	private static final long serialVersionUID = 1L;
	
	public DiscenteDAO() {
		setClazz(Discente.class);
	}

}
