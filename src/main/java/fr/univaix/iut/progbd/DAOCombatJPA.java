package fr.univaix.iut.progbd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOCombatJPA {
	private EntityManager entityManager;

	public DAOCombatJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean delete(Combat combat) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(combat);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Combat> findAll() {
		TypedQuery<Combat> query = entityManager.createNamedQuery(
				Combat.FIND_ALL, Combat.class);
		return query.getResultList();
	}

	public Combat getById(int id) {
		return entityManager.find(Combat.class, id);
	}

	public Combat insert(Combat combat) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(combat);
		tx.commit();
		return entityManager.find(Combat.class, combat.getIdcombat());
	}

	public boolean update(Combat combat) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.refresh(combat);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
