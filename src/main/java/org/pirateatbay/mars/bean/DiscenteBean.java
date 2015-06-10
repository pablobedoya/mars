package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.DiscenteDAO;
import org.pirateatbay.mars.model.Discente;

@ViewScoped
@ManagedBean
public class DiscenteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Discente discente = new Discente();
	private List<Discente> discentes;
	private DiscenteDAO discenteDAO = new DiscenteDAO();
	private boolean editSelected;

	public Discente getDiscente() {
		return discente;
	}
	
	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	
	public List<Discente> getDiscentes() {
		discentes = discentes == null ? findAll() : discentes;
		return discentes;
	}
	
	public boolean isEditSelected() {
		return editSelected;
	}
	
	public void setEditSelected(boolean selected) {
		this.editSelected = selected;
	}
	
	public void show() {
		setEditSelected(true);
	}
	
	public void hide() {
		setEditSelected(false);
	}
	
	public Discente findDiscente() {
		Discente e = discenteDAO.find(discente.getIdDiscente());
		return e;
	}
	
	public List<Discente> findAll() {
		discentes = discenteDAO.findAll();
		return discentes;
	}
	
	public String createDiscente() {
		discenteDAO.save(discente);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String updateDiscente() {
		Discente e = discenteDAO.find(discente.getIdDiscente());
		discenteDAO.update(e);
		discentes = null; // Update list 'discentes'
		return "remover_discente.xhtml";
	}
	
	public String deleteDiscente() {
		Discente e = discenteDAO.find(discente.getIdDiscente());
		discenteDAO.delete(e);
		discentes = null; // Update list 'discentes'
		return "remover_discente.xhtml";
	}
	
	public String cancel() {
		return "/secured/index.xhtml?faces-redirect=true";
	}

}
