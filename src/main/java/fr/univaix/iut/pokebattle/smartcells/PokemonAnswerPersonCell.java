package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerPersonCell implements SmartCell {
	Pokemon carapuce = new Pokemon("carapuce_bot", "Skwalop skwalop");

	public String ask(Tweet Question) {
		String Resultat = null;
		if (Question.getText().contains("Salut")
				| Question.getText().contains("salut")) {
			
			
			
			String date= new GregorianCalendar().getTime().toString();
			Resultat = "@" + Question.getScreenName() + " "
					+ carapuce.getCriPoke()+" "+date;
			
		
			return Resultat;
		}
		return Resultat;

	}


}
