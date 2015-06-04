package org.pirateatbay.mars.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Especialista {

	@Id
	private long idEspecialista;

	@MapsId
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	private String area;
	private String numeroConselho;

	public long getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(long idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNumeroConselho() {
		return numeroConselho;
	}

	public void setNumeroConselho(String numeroConselho) {
		this.numeroConselho = numeroConselho;
	}

}