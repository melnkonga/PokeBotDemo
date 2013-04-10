package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAODresseur {
	private EntityManager entityManager;

	public DAODresseur(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean delete(Dresseur dresseur) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(dresseur);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Dresseur getById(String nom) {
		return entityManager.find(Dresseur.class, nom);
	}

	public Dresseur insert(Dresseur dresseur) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(dresseur);
		tx.commit();
		return entityManager.find(Dresseur.class, dresseur.getNom());
	}

	public boolean update(Dresseur dresseur) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(dresseur);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
