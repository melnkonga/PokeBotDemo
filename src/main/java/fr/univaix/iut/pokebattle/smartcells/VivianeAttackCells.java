package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class VivianeAttackCells implements SmartCell {

	@Override
	public String ask(Tweet question) {

		String Resultat = null;
		String nomProprio = null;
		String nomPokemonAdvsaire = null;

		if (question.getText().contains("#attack")) {
			if (!question.getScreenName().equals("carapuce_bot"))// rajouter
																	// liste
																	// pokemon
				return null;

			String delimiter = " ";
			String[] texteTweet = question.getText().split(delimiter);

			int cpt = 0;
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					++cpt;
					if (cpt == 1)
						nomPokemonAdvsaire = texteTweet[i];

					if (cpt == 3)
						nomProprio = texteTweet[i];
				}

			}

			Resultat = nomPokemonAdvsaire + " -10 pv /cc " + nomProprio;
			return Resultat;

		}
		return null;
	}

}