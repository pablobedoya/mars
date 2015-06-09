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

	public void createCurso() {
		cursoDAO.save(curso);
	}

	public void updateCurso() {
		Curso c = cursoDAO.find(curso.getIdCurso());
		cursoDAO.update(c);
	}

	public void deleteCurso() {
		Curso c = cursoDAO.find(curso.getIdCurso());
		cursoDAO.delete(c);
	}

	public String cancel() {
		return "index.xhtml";
	}

}
