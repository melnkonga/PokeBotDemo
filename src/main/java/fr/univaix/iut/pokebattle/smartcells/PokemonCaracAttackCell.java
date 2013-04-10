package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracAttackCell {

	private Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop",
			"youvannn");

	public Pokemon getCarapuce() {
		return carapuce;
	}

	public void setCarapuce(Pokemon carapuce) {
		this.carapuce = carapuce;
	}

	public String ask(Tweet Question) {
		int ppCourant = 0;
		if (Question.getText().contains("#statAttack")) {
			if (Question.getText().contains("#charge")) {
				ppCourant = carapuce.getPPCourant();
				return "@" + carapuce.getOwnerPoke() + " #charge #PP="
						+ ppCourant + "/" + carapuce.getPP() + " "
						+ new GregorianCalendar().getTime().toString();
			} else if (Question.getText().contains("#ecume")) {
				ppCourant = carapuce.getPPCourant();
				return "@" + carapuce.getOwnerPoke() + " #ecume #PP="
						+ ppCourant + "/" + carapuce.getPP() + " "
						+ new GregorianCalendar().getTime().toString();
			} else {
				return "@" + carapuce.getOwnerPoke() + " attaque inconnue "
						+ new GregorianCalendar().getTime().toString();
			}
		}
		return null;
	} // ask
}