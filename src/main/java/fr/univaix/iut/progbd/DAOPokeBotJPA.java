package fr.univaix.iut.progbd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOPokeBotJPA implements DAOPokeBot {
	private EntityManager entityManager;

	public DAOPokeBotJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean delete(PokeBot pokebot) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(pokebot);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<PokeBot> findAll() {
		TypedQuery<PokeBot> query = entityManager.createNamedQuery(
				PokeBot.FIND_ALL, PokeBot.class);
		return query.getResultList();
	}

	@Override
	public PokeBot getById(String id) {
		return entityManager.find(PokeBot.class, id);
	}

	@Override
	public PokeBot insert(PokeBot pokebot) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pokebot);
		tx.commit();
		return entityManager.find(PokeBot.class, pokebot.getNom());
	}

	@Override
	public boolean update(PokeBot pokebot) {
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(pokebot);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<PokeBot> findByType(Pokemon pokemonType) {
		// TODO Auto-generated method stub
		return null;
	}
}
