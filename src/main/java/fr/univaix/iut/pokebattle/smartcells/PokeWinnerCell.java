package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeWinnerCell implements SmartCell {
	private Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop", "youvannn");
	private Pokemon salameche = new Pokemon("salameche_bot", "salasala", "1nsanesuperstar");

	public Pokemon getCarapuce() {
		return carapuce;
	}

	public void setCarapuce(Pokemon carapuce) {
		this.carapuce = carapuce;
	}

	public Pokemon getSalameche() {
		return salameche;
	}

	public void setSalameche(Pokemon salameche) {
		this.salameche = salameche;
	}

	public String ask(Tweet question) {
		String nomWinnerOwner = null;
		String nomWinnerPoke = null;
		String delimiter = " ";
		String[] texteTweet = question.getText().split(delimiter);
		String nom = null;

		if (question.getText().contains("#KO")) {
			int cpt = 0;
			
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					++cpt;
					if (cpt == 2)
					{
						nomWinnerOwner = texteTweet[i];
					}
				}
			}			
			nom = "@" + carapuce.getOwnerPoke();
			if(nom.equals(nomWinnerOwner))
			{
				nomWinnerPoke = carapuce.getNomPoke();
			}
			
			nom = "@" + salameche.getOwnerPoke();
			if(nom.equals(nomWinnerOwner))
			{
				nomWinnerPoke = salameche.getNomPoke();
			}
			return "@" + nomWinnerPoke + " #win" +" "+new GregorianCalendar().getTime().toString();
		}		
		return null;
	
	} // ask ()
}
