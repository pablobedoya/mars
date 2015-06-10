package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.AgendamentoDAO;
import org.pirateatbay.mars.model.Agendamento;

@ViewScoped
@ManagedBean
public class AgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agendamento agendamento = new Agendamento();
	private List<Agendamento> agendamentos;
	private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
	private boolean editSelected;

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getAgendamentos() {
		agendamentos = agendamentos == null ? findAll() : agendamentos;
		return agendamentos;
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

	public Agendamento findAgendamento() {
		Agendamento a = agendamentoDAO.find(agendamento.getIdAgendamento());
		return a;
	}

	public List<Agendamento> findAll() {
		List<Agendamento> agendamentos = agendamentoDAO.findAll();
		return agendamentos;
	}

	public String createAgendamento() {
		agendamentoDAO.save(agendamento);
		return "index.xhtml?faces-redirect=true";
	}

	public String updateAgendamento() {
		Agendamento a = agendamentoDAO.find(agendamento.getIdAgendamento());
		agendamentoDAO.update(a);
		agendamentos = null;
		return "remover_agendamento.xhtml";
	}

	public String deleteAgendamento() {
		Agendamento a = agendamentoDAO.find(agendamento.getIdAgendamento());
		agendamentoDAO.delete(a);
		agendamentos = null;
		return "remover_agendamento.xhtml";
	}
	
	public String cancel() {
		return "index.xhtml?faces-redirect=true";
	}

}
