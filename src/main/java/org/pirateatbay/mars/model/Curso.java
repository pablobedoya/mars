package org.pirateatbay.mars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private long idCurso;
	
	private String nome;
	private String nivel;
	
	@Column(name = "codigo_mec")
	private String codigoMec;

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCodigoMec() {
		return codigoMec;
	}

	public void setCodigoMec(String codigoMec) {
		this.codigoMec = codigoMec;
	}
	
	@Override
	public int hashCode() {
		return (int) getIdCurso();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Curso) {
			Curso curso = (Curso) obj;
			return curso.getIdCurso() == idCurso;
		}

		return false;
	}

}
