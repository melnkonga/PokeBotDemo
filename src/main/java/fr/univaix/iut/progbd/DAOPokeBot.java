package fr.univaix.iut.progbd;

import java.util.List;

public interface DAOPokeBot extends DAO<PokeBot, String> {
	List<PokeBot> findByType(Pokemon pokemonType);
}
