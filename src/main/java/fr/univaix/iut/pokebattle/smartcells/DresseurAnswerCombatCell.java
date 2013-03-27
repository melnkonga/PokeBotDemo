package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurAnswerCombatCell implements SmartCell{
	
	public String ask(Tweet question) {

		Pokemon salameche = new Pokemon("salameche","Blabla","neyo33");	
		String result="";

		if (question.getText().contains("#fight")) {
				result = "@" + question.getScreenName() + " #fight #ok with" 
						+ " @" + salameche.getNomPoke() + " /cc" + " @JugeViviane"; 
			}
		return result;

	}
}
