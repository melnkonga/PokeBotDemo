package fr.univaix.iut.pokebattle.smartcells;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonPertePVCell implements SmartCell {

	public String ask(Tweet question) {
		String Resultat = null;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);
		String delimiter = " ";
		String nomPoke = "";
		String str[] = question.getText().split(delimiter);
		for (int i = 0; i < str.length; i++) {
			if (str[i].contains("@")) {
				nomPoke = str[i];
				// nomPoke.replace("@", "");
			}  
		}
		PokeBot carapuce = daoBotJPA.getById("carapuce_bot");
		String owner = daoBotJPA.getById("carapuce_bot").getOwner().getNom();

		if ((question.getScreenName()).equals("JugeViviane")) {

			if (question.getText().contains("-10pv")) {
				carapuce.setPv(carapuce.getPv() - 10);
				if (daoBotJPA.getById("carapuce_bot").getPv() == 0) {
					Resultat = "#KO /cc @JugeViviane @" + owner;
				}
			}

		}
		return Resultat;
	}

}
