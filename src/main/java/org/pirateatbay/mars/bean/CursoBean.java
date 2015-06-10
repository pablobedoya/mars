package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.CursoDAO;
import org.pirateatbay.mars.model.Curso;

@ViewScoped
@ManagedBean
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Curso curso = new Curso();
	private List<Curso> cursos;
	private CursoDAO cursoDAO = new CursoDAO();

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		cursos = cursos == null ? findAll() : cursos;
		return cursos;
	}

	public Curso findCurso() {
		Curso c = cursoDAO.find(curso.getIdCurso());
		return c;
	}

	public List<Curso> findAll() {
		List<Curso> cursos = cursoDAO.findAll();
		return cursos;
	}

	public String createCurso() {
		cursoDAO.save(curso);
		return "index.xhtml?faces-redirect=true";
	}

	public String updateCurso() {
		Curso c = cursoDAO.find(curso.getIdCurso());
		cursoDAO.update(c);
		cursos = null;
		return "remover_curso.xhtml";
	}

	public String deleteCurso() {
		Curso c = cursoDAO.find(curso.getIdCurso());
		cursoDAO.delete(c);
		cursos = null;
		return "remover_curso.xhtml";
	}
	
	public String cancel() {
		return "index.xhtml?faces-redirect=true";
	}

}
