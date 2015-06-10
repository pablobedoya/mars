package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Participante;

public class ParticipanteDAO extends GenericDAO<Participante> {
	
	private static final long serialVersionUID = 1L;
	
	public ParticipanteDAO() {
		setClazz(Participante.class);
	}
	
}
