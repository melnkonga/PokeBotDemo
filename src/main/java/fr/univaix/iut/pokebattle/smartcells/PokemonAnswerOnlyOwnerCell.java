package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerOnlyOwnerCell implements SmartCell {

	public String ask(Tweet question) {

		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"J_Apple_Junior");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("#attack")) {
			if (owner != question.getScreenName()) {
				return ("@" + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner");
			}
		}
		return null;

	}
}
