package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOJuge_Combat {
	private EntityManager entityManager;

	public DAOJuge_Combat(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean delete(Juge_Combat juge) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(juge);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Dresseur insert(Juge_Combat juge) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(juge);
		tx.commit();
		return entityManager.find(Dresseur.class, juge.getNom());
	}

	public boolean update(Juge_Combat juge) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(juge);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Juge_Combat getById(String nom) {
		return entityManager.find(Juge_Combat.class, nom);
	}

}
