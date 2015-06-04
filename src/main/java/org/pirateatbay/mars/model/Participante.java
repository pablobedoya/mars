package org.pirateatbay.mars.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@IdClass(IdPartComposto.class)
public class Participante {	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_agendamento")
	private Agendamento agendamento;
	
	@Id
	@OneToOne
	@JoinColumn(name="id_discente")
	private Discente discente;
	
	private String situacao;

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
