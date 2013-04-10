package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAODresseur;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.Dresseur;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonNoCatchCell implements SmartCell {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOPokeBotJPA dao;
	private static DAODresseur dao2;
	
	public String ask(Tweet question) {
		/* bonne class */
		
		entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePU");
		entityManager = entityManagerFactory.createEntityManager();
		dao = new DAOPokeBotJPA(entityManager);
		dao2 = new DAODresseur(entityManager);
		
		String interloc = question.getScreenName();
		
		PokeBot pokebot = new PokeBot();
		String nompokebot = "";
		Pattern p = Pattern.compile("@(.*) ");
		Matcher m = p.matcher(question.getText());
		
		if(m.find())
			nompokebot = m.group(1);
		if (question.getText().contains("Pokeball")
				| question.getText().contains("pokeball")) {
			pokebot = dao.getById(nompokebot);
			if (pokebot.getOwner()== null) {  
				Dresseur dresseur = new Dresseur();
				String nomdresseur = interloc;
				dresseur = dao2.getById(nomdresseur);
				pokebot.setOwner(dresseur);
			}

			String s = "@" + question.getScreenName() + " @" + pokebot.getOwner().getNom()
					+ " is my owner"+" "+new GregorianCalendar().getTime().toString();
			return s;
		}

		return null;
	}

}
