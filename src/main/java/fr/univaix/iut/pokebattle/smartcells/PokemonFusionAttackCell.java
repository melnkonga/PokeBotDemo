package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonFusionAttackCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		String Resultat = null;
		String nomAttaque = null;
		String nomPokemonAdvsaire = null;
		String nomDressAdv = null;
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"1nsanesuperstar");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("#attack")) {

			if (owner.equals(question.getScreenName()) ) {
				String delimiter = " ";
				String[] texteTweet = question.getText().split(delimiter);

				int Cpt = 0;
				
				for (int i = 0; i < texteTweet.length; ++i) {
					
					if (texteTweet[i].contains("#attack"))
						nomAttaque = texteTweet[i + 1];
					
					
					if (texteTweet[i].contains("@")) {
						++Cpt;
						if (Cpt == 2)
							nomPokemonAdvsaire = texteTweet[i];
						if (Cpt == 3)
							nomDressAdv=texteTweet[i];
					}
					
				}
				Resultat = nomPokemonAdvsaire + " #attack " + nomAttaque
						+ " /cc " + nomDressAdv + " @"
						+ question.getScreenName() + " @JugeViviane";

					return Resultat;

			} 
			else{
				return ("@" + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner");
			}
				
		}
		return null;
	}
}
