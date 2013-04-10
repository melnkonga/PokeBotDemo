package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.Pokemon;
import fr.univaix.iut.progbd.PokeBot;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOPokeBotJPA dao;

	public String ask(Tweet question) {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("pokebattlePU");
		entityManager = entityManagerFactory.createEntityManager();
		dao = new DAOPokeBotJPA(entityManager);

		String interloc = question.getScreenName(); // @.....
		PokeBot pokebot = new PokeBot();
		Pokemon pokemon = new Pokemon();
		String nompokebot = "";
		Pattern p = Pattern.compile("@([^ ]*) ");
		Matcher m = p.matcher(question.getText());
		if (m.find()) {
			nompokebot = m.group(1);
		}
		if (question.getText().contains("salut")) {
			pokebot = dao.getById(nompokebot);
			System.out.println(nompokebot);
			System.out.println(pokebot);
			pokemon = pokebot.getTypePokemon();
			return "@" + interloc + " " + pokemon.getCri() + " #pokebattle " + new GregorianCalendar().getTime().toString();
		} 
		else {
			return null;
		}
	} //ask ()
}