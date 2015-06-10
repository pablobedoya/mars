package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.ParticipanteDAO;
import org.pirateatbay.mars.model.Participante;

@ViewScoped
@ManagedBean
public class ParticipanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Participante participante = new Participante();
	private List<Participante> participantes;
	private ParticipanteDAO participanteDAO = new ParticipanteDAO();
	private boolean editSelected;
	
	public Participante getParticipante() {
		return participante;
	}
	
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public List<Participante> getParticipantes() {
		participantes = participantes == null ? findAll() : participantes;
		return participantes;
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

	/*
	public Participante findParticipante() {
		Participante p = participanteDAO.find(participante.getIdParticipante());
		return p;
	}
	*/
	
	public List<Participante> findAll() {
		List<Participante> participantes = participanteDAO.findAll();
		return participantes;
	}
	
	public String createParticipante() {
		participanteDAO.save(participante);
		return "index.xhtml?faces-redirect=true";
	}
	
	/*
	public String updateParticipante() {
		Participante p = participanteDAO.find(participante.getIdParticipante());
		participanteDAO.update(p);
		participantes = null;
		return "remover_participante.xhtml";
	}
	
	public String deleteParticipante() {
		Participante p = participanteDAO.find(participante.getIdParticipante());
		participanteDAO.delete(p);
		participantes = null;
		return "remover_participante.xhtml";
	}
	*/
	
	public String cancel() {
		return "/secured/index.xhtml?faces-redirect=true";
	}
	
}
