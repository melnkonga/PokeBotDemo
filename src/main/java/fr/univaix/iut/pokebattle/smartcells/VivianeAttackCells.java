package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class VivianeAttackCells implements SmartCell {

	@Override
	public String ask(Tweet question) {

		String resultat = null;
		String nomProprio = null;
		String nomPokemonAdvsaire = null;

		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"1nsanesuperstar");

		if (question.getText().contains("#attack")) {
			if (!question.getScreenName().equals("carapuce_bot")) {
				return null;
			}

			String delimiter = " ";
			String[] texteTweet = question.getText().split(delimiter);

			int cpt = 0;
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					++cpt;
					if (cpt == 1) {
						nomPokemonAdvsaire = texteTweet[i];
					}
					if (cpt == 3) {
						nomProprio = texteTweet[i];
					}

				}

			}

			resultat = nomPokemonAdvsaire + " -10 pv /cc " + nomProprio + " "
					+ new GregorianCalendar().getTime().toString();
			return resultat;

		}
		return null;
	}

}