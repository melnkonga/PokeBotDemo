package fr.univaix.iut.pokebattle.smartcells;

import java.util.GregorianCalendar;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerPersonCell implements SmartCell {
	private Pokemon carapuce = new Pokemon("carapuce_bot", "Skwalop skwalop");

	public Pokemon getCarapuce() {
		return carapuce;
	}

	public void setCarapuce(Pokemon carapuce) {
		this.carapuce = carapuce;
	}

	public String ask(Tweet Question) {
		String resultat = null;
		if (Question.getText().contains("Salut")
				| Question.getText().contains("salut")) {
			
			
			
			String date= new GregorianCalendar().getTime().toString();
			resultat = "@" + Question.getScreenName() + " "
					+ carapuce.getCriPoke()+" "+date;
			
		
			return resultat;
		}
		return resultat;

	}


}
