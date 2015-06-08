package org.pirateatbay.mars.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT_NAME = "mars";

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory factory;

	private JpaUtil() {
	}
	
	public static EntityManager getEntityManager() {
		if (JpaUtil.factory == null) {
			JpaUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = JpaUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = JpaUtil.factory.createEntityManager();
			JpaUtil.manager.set(em);
		}
		return em;
	}

}
