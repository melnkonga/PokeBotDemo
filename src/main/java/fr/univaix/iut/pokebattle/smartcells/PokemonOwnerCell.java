package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonOwnerCell implements SmartCell {

	public String ask(Tweet question) {

		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"J_Apple_Junior");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("owner")
				| question.getText().contains("Owner")) {
			if (owner != null) {
				return ('@' + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner");
			} else {
				return "no owner";
			}
		}

		else {
			return null;
		}
	}

}
