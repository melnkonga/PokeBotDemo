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
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"youvannn");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("#attack")) {			
			if (owner == question.getScreenName()){
				String delimiter = " ";
				String[] texteTweet = question.getText().split(delimiter);
				
				for (int i = 0; i < texteTweet.length; ++i) {
					if (texteTweet[i].contains("#attack"))
						nomAttaque = texteTweet[i + 1];
				}
				for (int i = texteTweet.length - 1; i > 0; --i) {
					if (texteTweet[i].contains("@")) {
						nomPokemonAdvsaire = texteTweet[i];
						break;
					}
				}

				Resultat = nomPokemonAdvsaire + " #attack " + nomAttaque
						+ " //cc " + "@" + question.getScreenName();
				return Resultat;
			}
			else 
				return ("@" + question.getScreenName() + " @" + carapuce.getOwnerPoke() + " is my owner");				
		}
		return Resultat;
	}
}
