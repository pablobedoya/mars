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
	
	private PessoaDao pessoaDao = new PessoaDao();
	
	public void createPessoa(Pessoa pessoa) {
		pessoaDao.save(pessoa);
	}
	
	public Pessoa findPessoa(long idPessoa) {
		Pessoa pessoa = pessoaDao.find(idPessoa);
		return pessoa;
	}
	
	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = pessoaDao.findAll();
		return pessoas;
	}
	
	public void updatePessoa(Pessoa pessoa) {
		Pessoa p = pessoaDao.find(pessoa.getIdPessoa());
		p.setMatricula(pessoa.getMatricula());
		p.setNome(pessoa.getNome());
		p.setCpf(pessoa.getCpf());
		p.setRg(pessoa.getRg());
		p.setPassaporte(pessoa.getPassaporte());
		p.setNacionalidade(pessoa.getNacionalidade());
		p.setDataNascimento(pessoa.getDataNascimento());
		p.setEmail(pessoa.getEmail());
		p.setTelefone(pessoa.getTelefone());
		pessoaDao.update(p);
	}
	
	public void deletePessoa(Pessoa pessoa) {
		Pessoa p = pessoaDao.find(pessoa.getIdPessoa());
		pessoaDao.delete(p);
	}
	
}
