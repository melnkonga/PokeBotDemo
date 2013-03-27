package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurAnswerCombatCell {
	public String ask(Tweet question) {

		Pokemon salameche = new Pokemon("Salameche","Blabla","neyo33");
		
		String result="";

		if (question.getText().contains("#fight")) {
				result = "@" + question.getScreenName() + " #fight #ok with" 
						+ " @" + salameche.getNomPoke() + " /cc" + " @JugeViviane"; 
			}
		return result;

	}
}
