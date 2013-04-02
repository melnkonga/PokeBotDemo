package fr.univaix.iut.progbd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOPokemonJPA {

	private EntityManager entityManager;

	public DAOPokemonJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean delete(Pokemon pokemon) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(pokemon);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Pokemon> findAll() {
		TypedQuery<Pokemon> query = entityManager.createNamedQuery(
				Pokemon.FIND_ALL, Pokemon.class);
		return query.getResultList();
	}

	public Pokemon getById(String id) {
		return entityManager.find(Pokemon.class, id);
	}

	public Pokemon insert(Pokemon pokemon) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pokemon);
		tx.commit();
		return entityManager.find(Pokemon.class, pokemon.getNom());
	}

	public boolean update(Pokemon pokemon) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(pokemon);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}