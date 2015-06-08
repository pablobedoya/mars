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
		success();
	}
	
	public void updateEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		especialistaDao.update(e);
	}
	
	public void deleteEspecialista() {
		Especialista e = especialistaDao.find(especialista.getIdEspecialista());
		System.out.println(especialista.getIdEspecialista());
		especialistaDao.delete(e);
	}
	
	public void clear() {
		especialista = new Especialista();
	}
	
	public void cancel() throws IOException {
		clear();
		String uri = "index.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}
	
	public void success() {
		clear();
	    try {
			String uri = "index.xhtml";
			FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void backward() throws IOException {
		clear();
		String uri = "cadastrar_especialista.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}
	
	public void forward() throws IOException {
	    String uri = "cadastrar_endereco.xhtml";
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}

}
