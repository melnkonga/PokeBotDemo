package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAttackCell implements SmartCell{
	Pokemon carapuce = new Pokemon("Carapuce_bot", "Skwalop skwalop", "youvann");

	public String ask(Tweet Question) {
		String Resultat = null;
		if (Question.getText().contains("#attack")) {
			String delemiter = " ";
			String[] texteTweet = Question.getText().split(delemiter);
			String nomAttaque = null;
			String nomPokemonAdvsaire = null;
			String nomJuge = null;
			
				
			for (int i = 0; i < texteTweet.length; ++i) {
				if (texteTweet[i].contains("#attack"))
					nomAttaque = texteTweet[i + 1];
			}
			
			for (int i = texteTweet.length - 1; i > 0; --i) {
				if (texteTweet[i].contains("@viviane")) {
					nomJuge = texteTweet[i];
					break;
				}
			}
			int Cpt = 0;
				for (int i = texteTweet.length - 1; i > 0; --i) {
					if (texteTweet[i].contains("@")) {
						++Cpt;
						if (Cpt == 2)
						{
							nomPokemonAdvsaire = texteTweet[i];
							break;
						}
					}
					else {
						nomPokemonAdvsaire = texteTweet[i +1];
						break;
					}
				}

			Resultat = nomPokemonAdvsaire + " #attack " + nomAttaque + " //cc "
						+"@" +Question.getScreenName();
			
			if (Question.getText().contains("viviane")) Resultat += " @viviane";
							
			return Resultat;
		}
		if (Question.getText().contains("viviane")) {
			Resultat += "@viviane";
		}
		return Resultat;
	}

}
