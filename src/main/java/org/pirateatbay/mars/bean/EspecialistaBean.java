package org.pirateatbay.mars.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.pirateatbay.mars.dao.EspecialistaDao;
import org.pirateatbay.mars.model.Especialista;

@SessionScoped
@ManagedBean
public class EspecialistaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Especialista especialista = new Especialista();
	private EspecialistaDao especialistaDao = new EspecialistaDao();
	
	public Especialista getEspecialista() {
		return especialista;
	}
	
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}
	
	public Especialista findEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		return e;
	}
	
	public List<Especialista> findAll() {
		List<Especialista> especialistas = especialistaDao.findAll();
		return especialistas;
	}
	
	public void createEspecialista() {
		especialistaDao.save(especialista);
		this.success();
	}
	
	public void updateEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		especialistaDao.update(e);
	}
	
	public void deleteEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		especialistaDao.delete(e);
	}
	
	public void clear() {
		this.especialista = new Especialista();
	}
	
	public void cancel() throws IOException {
		this.clear();
		String uri = "index.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}
	
	public void success() {
		this.clear();
	    try {
			String uri = "index.xhtml";
			FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void backward() throws IOException {
		this.clear();
		String uri = "cadastrar_especialista.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}
	
	public void forward() throws IOException {
	    String uri = "cadastrar_endereco.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}

}
