package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonOwnerCell implements SmartCell {

	public String ask(Tweet question) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
        EntityManager em = emf.createEntityManager();
        DAOPokeBotJPA daoPokeBotJPA= new DAOPokeBotJPA(em);
           
		PokeBot owner = daoPokeBotJPA.getById("carapuce_bot");
		System.out.println(owner.getOwner().getNom());
		
		if (question.getText().contains("owner")
				| question.getText().contains("Owner")) {
			if (owner != null) {
				return ('@' + question.getScreenName() + " @"
						+ owner + " is my owner"+" "+new GregorianCalendar().getTime().toString());
			} else {
				return "no owner";
			}
		}

		else {
			return null;
		}
	}

}
