package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCell implements SmartCell {
	Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop", "youvannn");

	public String ask(Tweet Question) {
		int level = 0;
		int XP = 0;
		int PVCourant = 0;
		if (Question.getText().contains("#stat")) {
			if (Question.getText().contains("#level")) {
				level = carapuce.getLevel();
				return "@" + carapuce.getOwnerPoke() + " #level=" + level  + " " + new GregorianCalendar().getTime().toString();
			}
			if (Question.getText().contains("#XP")) {
				XP = carapuce.getExp();
				return "@" + carapuce.getOwnerPoke() + " #XP=" + XP + " " + new GregorianCalendar().getTime().toString();
			}
			if (Question.getText().contains("#PV")) {
				PVCourant = carapuce.getPVCourant();
				return "@" + carapuce.getOwnerPoke() + " #PV=" + PVCourant + "/"
						+ carapuce.getPV() + " " + new GregorianCalendar().getTime().toString();
			}
		}
		return null;
	} // ask
}
