package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Polo;

public class PoloDao extends GenericDao<Polo> {

	private static final long serialVersionUID = 1L;
	
	public PoloDao () {
		setClazz(Polo.class);
	}
	
}
