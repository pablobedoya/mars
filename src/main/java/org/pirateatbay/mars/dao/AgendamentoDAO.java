package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Agendamento;

public class AgendamentoDAO extends GenericDAO<Agendamento> {
	
	private static final long serialVersionUID = 1L;
	
	public AgendamentoDAO() {
		setClazz(Agendamento.class);
	}
	
}
