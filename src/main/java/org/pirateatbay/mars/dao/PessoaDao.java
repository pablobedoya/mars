package org.pirateatbay.mars.dao;

import org.pirateatbay.mars.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDao() {
		setClazz(Pessoa.class);
	}

}
