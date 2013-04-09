package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonNoCatchCell implements SmartCell {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOPokeBotJPA dao;
	
	public String ask(Tweet question) {
		/* bonne class */
		
		entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePU");
		entityManager = entityManagerFactory.createEntityManager();
		dao = new DAOPokeBotJPA(entityManager);
		
		String interloc = question.getScreenName();
		PokeBot pokebot = new PokeBot();
		Pokemon pokemon = new Pokemon();
		String nompokebot = "";
		Pattern p = Pattern.compile("@(.*)");
		Matcher m = p.matcher(question.getText());
		
		if(m.find())
			nompokebot = m.group(1);
		
		pokebot = dao.getById(nompokebot);
		
		
		if (question.getText().contains("Pokeball")
				| question.getText().contains("pokeball")) {
			if (dao.getOwnerPoke() == null) {
				pokebot.setOwnerPoke(question.getScreenName());
			}
			String S = "@" + question.getScreenName() + " @" + cara.getOwnerPoke()
					+ " is my owner"+" "+new GregorianCalendar().getTime().toString();
			return S;
		}

		return null;
	}

}
