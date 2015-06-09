package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Polo;

public class PoloDAO extends GenericDAO<Polo> {

	private static final long serialVersionUID = 1L;
	
	public PoloDAO () {
		setClazz(Polo.class);
	}
	
}
