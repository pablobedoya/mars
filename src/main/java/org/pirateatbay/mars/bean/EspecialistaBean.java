package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.pirateatbay.mars.dao.EspecialistaDao;
import org.pirateatbay.mars.model.Especialista;

@SessionScoped
@ManagedBean
public class EspecialistaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Especialista especialista = new Especialista();
	private List<Especialista> especialistas;
	private EspecialistaDao especialistaDao = new EspecialistaDao();
	
	public Especialista getEspecialista() {
		return especialista;
	}
	
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}
	
	public List<Especialista> getEspecialistas() {
		especialistas = especialistas == null ? findAll() : especialistas;
		return especialistas;
	}
	
	public Especialista findEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		return e;
	}
	
	public List<Especialista> findAll() {
		especialistas = especialistaDao.findAll();
		return especialistas;
	}
	
	public void createEspecialista() {
		especialistaDao.save(especialista);
	}
	
	public void updateEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		especialistaDao.update(e);
		especialistas = null; // Update list 'especialistas'
	}
	
	public void deleteEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		especialistaDao.delete(e);
		especialistas = null; // Update list 'especialistas'
	}
	
	public String cancel() {
		return "index.xhtml";
	}
	
	public String success() {
		return "index.xhtml?faces-redirect=true";
	}
	
	public void backward() {
	}
	
	public void forward() {
	}

}
