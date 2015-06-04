package org.pirateatbay.mars.model;
import java.sql.Time;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	
	@Id
	private long agendamento;
	
	@ManyToOne
	@JoinColumn(name="id_especialista")
	private Especialista especialista;
	
	private Date data;
	private Time horario;
	private String tipo;
	private String observacao;
	
	
	public long getAgendamento() {
		return agendamento;
	}
	
	public void setAgendamento(long agendamento) {
		this.agendamento = agendamento;
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
	
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
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

}
