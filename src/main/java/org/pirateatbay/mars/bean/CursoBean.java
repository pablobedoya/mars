package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.CursoDao;
import org.pirateatbay.mars.model.Curso;

@ViewScoped
@ManagedBean
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Curso curso = new Curso();
	private List<Curso> cursos;
	private CursoDao cursoDao = new CursoDao();

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
		Curso c = cursoDao.find(curso.getIdCurso());
		return c;
	}

	public List<Curso> findAll() {
		List<Curso> cursos = cursoDao.findAll();
		return cursos;
	}

	public void createCurso() {
		cursoDao.save(curso);
	}

	public void updateCurso() {
		Curso c = cursoDao.find(curso.getIdCurso());
		cursoDao.update(c);
	}

	public void deleteCurso() {
		Curso c = cursoDao.find(curso.getIdCurso());
		cursoDao.delete(c);
	}

	public String cancel() {
		return "index.xhtml";
	}

}
