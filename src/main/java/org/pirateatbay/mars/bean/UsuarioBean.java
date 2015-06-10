package org.pirateatbay.mars.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

import org.pirateatbay.mars.dao.UsuarioDAO;
import org.pirateatbay.mars.model.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private String username;
	private String password; 

	public String login() {
		try {
			usuario = usuarioDAO.find(username, password);
			
			if (usuario != null) {
				return "index?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome de usuário desconhecido e/ou senha inválida."));
				return (username = password = null);
			}
		} catch (NoResultException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falha ao carregar usuário."));
			return null;
		}
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
	
	public boolean isLoggedIn() {
		return usuario != null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
