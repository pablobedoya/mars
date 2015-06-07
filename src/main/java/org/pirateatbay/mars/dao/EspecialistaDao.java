package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Especialista;

public class EspecialistaDao extends GenericDao<Especialista> {

	private static final long serialVersionUID = 1L;
	
	public EspecialistaDao() {
		setClazz(Especialista.class);
	}

}
