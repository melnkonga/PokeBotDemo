package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeWinnerCell implements SmartCell {
	Pokemon carapuce = new Pokemon("carapuce_bot", "skwalop", "youvannn");
	Pokemon salameche = new Pokemon("salameche_bot", "salasala", "1nsanesuperstar");

	public String ask(Tweet question) {
		String nomWinnerOwner = null;
		String nomWinnerPoke = null;
		String delimiter = " ";
		String[] texteTweet = question.getText().split(delimiter);
		String nom = null;

		if (question.getText().contains("#KO")) {
			int Cpt = 0;
			
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("@")) {
					++Cpt;
					if (Cpt == 2)
						nomWinnerOwner = texteTweet[i];
				}
			}			
			nom = "@" + carapuce.getOwnerPoke();
			if(nom.equals(nomWinnerOwner))
				nomWinnerPoke = carapuce.getNomPoke();
			
			nom = "@" + salameche.getOwnerPoke();
			if(nom.equals(nomWinnerOwner))
				nomWinnerPoke = salameche.getNomPoke();
		}		
		return "@" + nomWinnerPoke + " #win";
	
	} // ask ()
}
