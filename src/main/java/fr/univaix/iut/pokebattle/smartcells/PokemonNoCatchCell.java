package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

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
					+ " is my owner"+" "+new GregorianCalendar().getTime().toString();
			return S;
		}

		return null;
	}

}
