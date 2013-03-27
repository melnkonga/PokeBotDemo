package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell {

	public String ask(Tweet question) {

		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"J_Apple_Junior");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("owner")
				| question.getText().contains("Owner")) {
			if (owner != null) {
				return ('@' + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner"+" "+new GregorianCalendar().getTime().toString());
			} else {
				return "no owner";
			}
		}

		else {
			return null;
		}
	}

}
