package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.AtendimentoDAO;
import org.pirateatbay.mars.model.Atendimento;

@ViewScoped
@ManagedBean
public class AtendimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Atendimento atendimento = new Atendimento();
	private List<Atendimento> atendimentos;
	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
	private boolean editSelected;

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<Atendimento> getAtendimentos() {
		atendimentos = atendimentos == null ? findAll() : atendimentos;
		return atendimentos;
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

	public Atendimento findAtendimento() {
		Atendimento a = atendimentoDAO.find(atendimento.getIdAtendimento());
		return a;
	}

	public List<Atendimento> findAll() {
		List<Atendimento> atendimentos = atendimentoDAO.findAll();
		return atendimentos;
	}

	public String createAtendimento() {
		atendimentoDAO.save(atendimento);
		return "index.xhtml?faces-redirect=true";
	}

	public String updateAtendimento() {
		Atendimento a = atendimentoDAO.find(atendimento.getIdAtendimento());
		atendimentoDAO.update(a);
		atendimentos = null;
		return "remover_atendimento.xhtml";
	}

	public String deleteAtendimento() {
		Atendimento a = atendimentoDAO.find(atendimento.getIdAtendimento());
		atendimentoDAO.delete(a);
		atendimentos = null;
		return "remover_atendimento.xhtml";
	}
	
	public String cancel() {
		return "index.xhtml?faces-redirect=true";
	}

}
