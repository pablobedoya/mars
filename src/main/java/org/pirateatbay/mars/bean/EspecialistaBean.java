package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.EspecialistaDAO;
import org.pirateatbay.mars.model.Especialista;

@ViewScoped
@ManagedBean
public class EspecialistaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Especialista especialista = new Especialista();
	private List<Especialista> especialistas;
	private EspecialistaDAO especialistaDAO = new EspecialistaDAO();
	
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
		Especialista e = especialistaDAO.find(especialista.getIdEspecialista());
		return e;
	}
	
	public List<Especialista> findAll() {
		especialistas = especialistaDAO.findAll();
		return especialistas;
	}
	
	public String createEspecialista() {
		especialistaDAO.save(especialista);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String updateEspecialista() {
		Especialista e = especialistaDAO.find(especialista.getIdEspecialista());
		especialistaDAO.update(e);
		especialistas = null; // Update list 'especialistas'
		return "remover_especialista.xhtml";
	}
	
	public String deleteEspecialista() {
		Especialista e = especialistaDAO.find(especialista.getIdEspecialista());
		especialistaDAO.delete(e);
		especialistas = null; // Update list 'especialistas'
		return "remover_especialista.xhtml";
	}
	
	public String cancel() {
		return "index.xhtml";
	}
	
	public void backward() {
	}
	
	public void forward() {
	}

}
