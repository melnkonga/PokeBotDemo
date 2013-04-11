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

public class PokemonPertePVCell implements SmartCell {

	public String ask(Tweet question) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");  
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);
		DAODresseur daoDressJPA = new DAODresseur(em);

		PokeBot pokebot = new PokeBot();
		String nompokebot = "";
		Pattern p = Pattern.compile("@([^ ]*) ");
		Matcher m = p.matcher(question.getText());

		if (m.find()) {
			nompokebot = m.group(1);
		}
		
		pokebot = daoBotJPA.getById(nompokebot);
		Dresseur dresseur = new Dresseur();
		dresseur = pokebot.getOwner();

		if ((question.getScreenName()).equals("JugeViviane")) {
			if (question.getText().contains("-10pv")) {
				pokebot.setPv(pokebot.getPv() - 10);
				daoBotJPA.update(pokebot);
				if (pokebot.getPv() == 0) {
					return "#KO /cc @JugeViviane @" + dresseur.getNom() + " #pokebattle "
							/* new GregorianCalendar().getTime().toString()*/;
				}
			}
		}
		return null;
	}

}
