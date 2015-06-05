package org.pirateatbay.mars.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Class<T> clazz;

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mars");
	private EntityManager manager = factory.createEntityManager();
	
	public void setClazz(final Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T find(final Long id) {
		return manager.find(clazz, id);
	}
	
	public List<T> findAll() {
		return manager.createQuery("SELECT e FROM "+ clazz.getSimpleName() + " e").getResultList();
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
