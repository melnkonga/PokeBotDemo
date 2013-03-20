package fr.univaix.iut.pokebattle.smartcells;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAttackCell {
	Pokemon carapuce = new Pokemon("Carapuce_bot", "Skwalop skwalop",
			"youvann");

	public String ask(Tweet Question) {
		String Resultat = null;
		if (Question.getText().contains("attack")) {
			String delemiter = " ";
			String[] texteTweet = Question.getText().split(delemiter);
			String nomAttaque = null;
			String nomPokemonAdvsaire = null;

			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("#attack"))
					nomAttaque = texteTweet[i + 1];
			}

			for (int i = texteTweet.length - 1; i > 0; --i) {
				if (texteTweet[i].contains("@"))
					nomPokemonAdvsaire = texteTweet[i];
			}

			Resultat = nomPokemonAdvsaire + " #attack " + nomAttaque + " //cc "
					+ Question.getScreenName();
			return Resultat;
		}
		return Resultat;
	}

}
