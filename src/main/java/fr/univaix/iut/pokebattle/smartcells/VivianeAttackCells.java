package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class VivianeAttackCells implements SmartCell {

	@Override
	public String ask(Tweet question) {

		String Resultat = null;
		String nomProprio = null;
		String nomPokemonAdvsaire = null;
		
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"1nsanesuperstar");
		
		
		if (question.getText().contains("#attack")) {
			if (!question.getScreenName().equals(carapuce.getOwnerPoke()))// rajouter
																	// liste
																	// pokemon
				return null;

			String delimiter = " ";
			String[] texteTweet = question.getText().split(delimiter);

			int cpt = 0;
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					++cpt;
					if (cpt == 2)
						nomPokemonAdvsaire = texteTweet[i];
					/*
					if (cpt == 3)
						nomProprio = texteTweet[i];
					*/
				}

			}

			Resultat = nomPokemonAdvsaire + " -10 pv /cc " + "@"+question.getScreenName();
			return Resultat;

		}
		return null;
	}

}