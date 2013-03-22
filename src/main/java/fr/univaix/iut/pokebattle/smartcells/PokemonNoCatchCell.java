package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonNoCatchCell implements SmartCell {

	public String ask(Tweet question) {
		/* bonne class */
		Pokemon cara = new Pokemon("carapuce", "Skwalop Skwalop",
				"J_Apple_Junior");

		if (question.getText().contains("Pokeball")
				| question.getText().contains("pokeball")) {
			if (cara.getOwnerPoke() == null) {
				cara.setOwnerPoke(question.getScreenName());
			}
			String S = "@" + question.getScreenName() + " @" + cara.getOwnerPoke()
					+ " is my owner";
			return S;
		}

		return null;
	}

}
