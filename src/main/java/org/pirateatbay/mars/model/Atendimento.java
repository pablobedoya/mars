package org.pirateatbay.mars.model;
import java.sql.Time;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Atendimento {
	
	@Id
	private long atendimento;
	
	@ManyToOne
	@JoinColumn(name="id_discente")
	private Discente discente;
		
	@ManyToOne
	@JoinColumn(name="id_especialista")
	private Especialista especialista;
	

	private Date data;
	private Time horario;
	private String situacao;
	private String observacao;
	
	
	public long getAtendimento() {
		return atendimento;
	}
	
	public void setAtendimento(long atendimento) {
		this.atendimento = atendimento;
	}
	
	public Discente getDiscente() {
		return discente;
	}
	
	public void setDiscente(Discente discente) {
		this.discente = discente;
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
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
