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
import fr.univaix.iut.progbd.PokeBot;
import fr.univaix.iut.progbd.Pokemon;

public class PokemonOwnerCell implements SmartCell {

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
		String nompokebot = "";
		Pattern p = Pattern.compile("@([^ ]*) ");
		Matcher m = p.matcher(question.getText());
		if (m.find()) {
			nompokebot = m.group(1);
		}
		if (question.getText().contains("owner")) {
			pokebot = dao.getById(nompokebot);
			System.out.println(pokebot);
			String nom_dress = pokebot.getOwner().getNom();
			System.out.println(nom_dress);
			return "@" + interloc + " @" + nom_dress + " is my owner" + " #pokebattle " + new GregorianCalendar().getTime().toString();
		} 
		else {
			return null;
		}
	} //ask ()
}

/*
public String ask(Tweet question) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoPokeBotJPA = new DAOPokeBotJPA(em);

		String nompokebot = null;
		Pattern p = Pattern.compile("@([^ ]*) ");
		Matcher m = p.matcher(question.getText());

		if (m.find()) {
			nompokebot = m.group(1);
		}
		PokeBot owner = daoPokeBotJPA.getById(nompokebot);

		if (question.getText().contains("owner") | question.getText().contains("Owner")) {
			if (owner.getOwner() == null) {
				return ('@' + question.getScreenName() + " no owner");
			}
			String nom_dress = owner.getOwner().getNom();
			return '@' + question.getScreenName() + " @" + nom_dress + " is my owner #pokebattle";
		}
		return null;
	}
*/
