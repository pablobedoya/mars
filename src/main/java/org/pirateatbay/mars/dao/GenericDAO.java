package org.pirateatbay.mars.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.pirateatbay.mars.util.JpaUtil;

public abstract class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Class<T> clazz;
	
	protected EntityManager manager = JpaUtil.getEntityManager();
	
	public void setClazz(final Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T find(final long id) {
		T t = manager.find(clazz, id);
		return t;
	}
	
	public List<T> findAll() {
		List<T> list = manager.createQuery("SELECT e FROM "+ clazz.getSimpleName() + " e").getResultList();
		return list;
	}
	
	public void save(final T entity) {
		try {
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public void update(final T entity) {
		try {
			manager.getTransaction().begin();
			manager.merge(this.manager.merge(entity));
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public void delete(final T entity) {
		try {
			manager.getTransaction().begin();
			manager.remove(entity);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
}
