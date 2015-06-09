package org.pirateatbay.mars.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento")
	private long idAgendamento;
	
	@ManyToOne
	@JoinColumn(name="id_especialista")
	private Especialista especialista;

	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String horario;
	private String tipo;
	private String observacao;
	
	public long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Especialista getEspecialista() {
		return especialista;
	}
	
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getObservacao() {
		return observacao;
	}	
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public int hashCode() {
		return (int) getIdAgendamento();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Agendamento) {
			Agendamento agendamento = (Agendamento) obj;
			return agendamento.getIdAgendamento() == idAgendamento;
		}

		return false;
	}

}
