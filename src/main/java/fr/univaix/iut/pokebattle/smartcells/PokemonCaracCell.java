package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell {
	Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop", "youvannn");

	public String ask(Tweet Question) {
		int level = 0;
		int xp = 0;
		int pvCourant = 0;
		if (Question.getText().contains("#stat")) {
			if (Question.getText().contains("#level")) {
				level = carapuce.getLevel();
				return "@" + carapuce.getOwnerPoke() + " #level=" + level + " "
						+ new GregorianCalendar().getTime().toString();
			}
			if (Question.getText().contains("#xp")) {
				xp = carapuce.getExp();
				return "@" + carapuce.getOwnerPoke() + " #xp=" + xp + " "
						+ new GregorianCalendar().getTime().toString();
			}
			if (Question.getText().contains("#PV")) {
				pvCourant = carapuce.getPVCourant();
				return "@" + carapuce.getOwnerPoke() + " #PV=" + pvCourant
						+ "/" + carapuce.getPV() + " "
						+ new GregorianCalendar().getTime().toString();
			}
		}
		return null;
	} // ask
}
