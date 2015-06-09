package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Especialista;

public class EspecialistaDAO extends GenericDAO<Especialista> {

	private static final long serialVersionUID = 1L;
	
	public EspecialistaDAO() {
		setClazz(Especialista.class);
	}

}
