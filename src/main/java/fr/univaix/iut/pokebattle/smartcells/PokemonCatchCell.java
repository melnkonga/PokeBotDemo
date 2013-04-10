package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCatchCell implements SmartCell {

	public String ask(Tweet question) {
		/* vielle classe */

		Pokemon cara = new Pokemon("carapuce", "skwalop");
		if (question.getText().contains("Pokeball")) {

			cara.setOwnerPoke(question.getScreenName());
			String s = "@" + question.getScreenName() + " @"
					+ cara.getOwnerPoke() + " is my owner";

			return s;

		}
		return null;

	}

}
