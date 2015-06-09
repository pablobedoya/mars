package org.pirateatbay.mars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Polo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_polo")
	private long idPolo;
	
	private String nome;
	private String cidade;
	
	@Column(name = "unidade_federativa")
	private String unidadeFederativa;

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

	public String getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}
	
	@Override
	public int hashCode() {
		return (int) getIdPolo();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Polo) {
			Polo polo = (Polo) obj;
			return polo.getIdPolo() == idPolo;
		}

		return false;
	}
	
}
