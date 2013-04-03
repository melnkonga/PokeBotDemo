package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracAttackCell {

		Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop", "youvannn");

		public String ask(Tweet Question) {
			int PPCourant = 0;
			if (Question.getText().contains("#statAttack")) {
				if (Question.getText().contains("#charge")) {
					PPCourant = carapuce.getPPCourant();
					return "@" + carapuce.getOwnerPoke() + " #charge #PP=" + PPCourant + "/"
						+ carapuce.getPP() + " " + new GregorianCalendar().getTime().toString();
				}
				else if (Question.getText().contains("#ecume")) {
					PPCourant = carapuce.getPPCourant();
					return "@" + carapuce.getOwnerPoke() + " #ecume #PP=" + PPCourant + "/"
							+ carapuce.getPP() + " " + new GregorianCalendar().getTime().toString();
				}
				else {
					return "@" + carapuce.getOwnerPoke() + " attaque inconnue " + new GregorianCalendar().getTime().toString();
				}
			}
			return null;
		} // ask
}