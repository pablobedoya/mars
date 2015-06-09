package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Discente;

public class DiscenteDao extends GenericDao<Discente> {
	
	private static final long serialVersionUID = 1L;
	
	public DiscenteDao() {
		setClazz(Discente.class);
	}

}
