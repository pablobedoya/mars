package org.pirateatbay.mars.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Discente {

	@Id
	private long idDiscente;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_discente")
	private Pessoa pessoa = new Pessoa();

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_polo")
	private Polo polo;

	public long getIdDiscente() {
		return idDiscente;
	}

	public void setIdDiscente(long idDiscente) {
		this.idDiscente = idDiscente;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Polo getPolo() {
		return polo;
	}

	public void setPolo(Polo polo) {
		this.polo = polo;
	}
	
	@Override
	public int hashCode() {
		return (int) getIdDiscente();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Discente) {
			Discente discente = (Discente) obj;
			return discente.getIdDiscente() == idDiscente;
		}

		return false;
	}

}
