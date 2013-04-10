package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonNameAdverseAttackCell implements SmartCell {

	private Pokemon carapuce = new Pokemon("Carapuce_bot", "Skwalop skwalop", "youvann");

	public Pokemon getCarapuce() {
		return carapuce;
	}

	public void setCarapuce(Pokemon carapuce) {
		this.carapuce = carapuce;
	}

	public String ask(Tweet Question) {
		String resultat = null;
		if (Question.getText().contains("attack")) {
			String delemiter = " ";
			String[] texteTweet = Question.getText().split(delemiter);
			String nomAttaque = null;
			String nomPokemonAdvsaire = null;
			String nomOwnerAdvsaire = null;

			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("#attack"))
				{
					nomAttaque = texteTweet[i + 1];
				}
			}

			for (int i = texteTweet.length - 1; i > 0; --i) {
				if (texteTweet[i].contains("@")) {
					nomOwnerAdvsaire = texteTweet[i];
					break;
				}
			}

			int cpt = 0;
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					cpt += 1;
					if (cpt == 2)
					{
						nomPokemonAdvsaire = texteTweet[i];
					}
				}
			}

			resultat = nomPokemonAdvsaire + " #attack " + nomAttaque + " /cc "
					+ nomOwnerAdvsaire + ' ' + Question.getScreenName();
			return resultat;
		}
		return resultat;
	}
}
