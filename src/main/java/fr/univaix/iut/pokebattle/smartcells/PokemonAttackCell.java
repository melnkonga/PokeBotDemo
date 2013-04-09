package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackCell implements SmartCell {
	Pokemon carapuce = new Pokemon("Carapuce_bot", "Skwalop skwalop", "youvann");

	public String ask(Tweet Question) {
		String resultat = null;
		if (Question.getText().contains("#attack")) {
			String delemiter = " ";
			String[] texteTweet = Question.getText().split(delemiter);
			String nomAttaque = null;
			String nomPokemonAdvsaire = null;
			String nomJuge = null;

			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("#attack"))
					nomAttaque = texteTweet[i + 1];
			}

			for (int i = texteTweet.length - 1; i > 0; --i) {
				if (texteTweet[i].contains("@JugeViviane")) {
					nomJuge = texteTweet[i];
					break;
				}
			}
			int cpt = 0;
			for (int i = texteTweet.length - 1; i > 0; --i) {
				if (texteTweet[i].contains("@")) {
					++cpt;
					if (cpt == 2) {
						nomPokemonAdvsaire = texteTweet[i];
						break;
					}
				} else {
					nomPokemonAdvsaire = texteTweet[i + 1];
					break;
				}
			}

			resultat = nomPokemonAdvsaire + " #attack " + nomAttaque + " //cc "
					+ "@" + Question.getScreenName();

			if (Question.getText().contains("@JugeViviane"))
				resultat += " @JugeViviane";

			return resultat;
		}
		if (Question.getText().contains("viviane")) {
			resultat += "@JugeViviane";
		}
		return resultat;
	}

}
