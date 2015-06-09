package org.pirateatbay.mars.dao;

import javax.persistence.Query;

import org.pirateatbay.mars.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = 1L;
	
	public UsuarioDAO() {
		setClazz(Usuario.class);
	}
	
	public Usuario find(String username, String password) {
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :username AND u.senha = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		return (Usuario) query.getSingleResult();
	}

}
