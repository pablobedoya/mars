package org.pirateatbay.mars.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.pirateatbay.mars.dao.PoloDao;
import org.pirateatbay.mars.model.Polo;

@ViewScoped
@ManagedBean
public class PoloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Polo polo = new Polo();
	private PoloDao poloDao = new PoloDao();
	
	public Polo getPolo() {
		return polo;
	}
	
	public void setPolo(Polo polo) {
		this.polo = polo;
	}
	
	public Polo findPolo() {
		Polo p = poloDao.find(polo.getIdPolo());
		return p;
	}
	
	public List<Polo> findAll() {
		List<Polo> polos = poloDao.findAll();
		return polos;
	}
	
	public void createPolo() {
		poloDao.save(polo);
	}
	
	public void updatePolo() {
		Polo p = poloDao.find(polo.getIdPolo());
		poloDao.update(p);
	}
	
	public void deletePolo() {
		Polo p = poloDao.find(polo.getIdPolo());
		poloDao.delete(p);
	}
	
	public void clear() {
		this.polo = new Polo();
	}
	
	public void cancel() throws IOException {
		this.clear();
		String uri = "index.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}
}