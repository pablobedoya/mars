package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Atendimento;

public class AtendimentoDAO extends GenericDAO<Atendimento> {
	
	private static final long serialVersionUID = 1L;
	
	public AtendimentoDAO() {
		setClazz(Atendimento.class);
	}
	
}
