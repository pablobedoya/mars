package org.pirateatbay.mars.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.pirateatbay.mars.dao.PessoaDao;
import org.pirateatbay.mars.model.Pessoa;

@ViewScoped
@ManagedBean
public class PessoaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	private PessoaDao pessoaDao = new PessoaDao();
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Pessoa findPessoa() {
		Pessoa p = pessoaDao.find(pessoa.getIdPessoa());
		return p;
	}
	
	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = pessoaDao.findAll();
		return pessoas;
	}

	public void createPessoa() {
		pessoaDao.save(pessoa);
	}
	
	public void updatePessoa() {
		Pessoa p = pessoaDao.find(pessoa.getIdPessoa());
		pessoaDao.update(p);
	}
	
	public void deletePessoa() {
		Pessoa p = pessoaDao.find(pessoa.getIdPessoa());
		pessoaDao.delete(p);
	}
	
}
