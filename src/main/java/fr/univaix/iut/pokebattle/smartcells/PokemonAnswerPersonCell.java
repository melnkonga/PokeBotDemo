package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerPersonCell implements fr.univaix.iut.pokebattle.smartcell.SmartCell {
	Pokemon carapuce = new Pokemon("carapuce_bot", "Skwalop skwalop");

	public String ask(Tweet Question) {
		String Resultat = null;
		if (Question.getText().contains("Salut")
				| Question.getText().contains("salut")) {
			Resultat = "@" + Question.getScreenName() + " "
					+ carapuce.getCriPoke();
			return Resultat;
		}
		return Resultat;

	}


}
