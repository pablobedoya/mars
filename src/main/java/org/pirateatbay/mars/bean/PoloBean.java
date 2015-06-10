package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.PoloDAO;
import org.pirateatbay.mars.model.Polo;

@ViewScoped
@ManagedBean
public class PoloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Polo polo = new Polo();
	private List<Polo> polos;
	private PoloDAO poloDAO = new PoloDAO();
	private boolean editSelected;
	
	public Polo getPolo() {
		return polo;
	}
	
	public void setPolo(Polo polo) {
		this.polo = polo;
	}
	
	public List<Polo> getPolos() {
		polos = polos == null ? findAll() : polos;
		return polos;
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

	public Polo findPolo() {
		Polo p = poloDAO.find(polo.getIdPolo());
		return p;
	}
	
	public List<Polo> findAll() {
		List<Polo> polos = poloDAO.findAll();
		return polos;
	}
	
	public String createPolo() {
		poloDAO.save(polo);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String updatePolo() {
		Polo p = poloDAO.find(polo.getIdPolo());
		poloDAO.update(p);
		polos = null;
		return "remover_polo.xhtml";
	}
	
	public String deletePolo() {
		Polo p = poloDAO.find(polo.getIdPolo());
		poloDAO.delete(p);
		polos = null;
		return "remover_polo.xhtml";
	}
	
	public String cancel() {
		return "/secured/index.xhtml?faces-redirect=true";
	}
	
}
