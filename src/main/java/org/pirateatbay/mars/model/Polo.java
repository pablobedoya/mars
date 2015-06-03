package org.pirateatbay.mars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Polo {

	@Id
	@GeneratedValue
	private long idPolo;
	
	private String nome;
	private String cidade;
	private String estado;

	public long getIdPolo() {
		return idPolo;
	}

	public void setIdPolo(long idPolo) {
		this.idPolo = idPolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
