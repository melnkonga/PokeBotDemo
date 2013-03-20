package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAnswerOnlyOwnerCell {

	public String ask(Tweet question) {
		
		Pokemon carapuce = new Pokemon("Carapuce","Skwalop Skwalop","@J_Apple_Junior");
		String owner=carapuce.getOwnerPoke();
		
		if (question.getText().contains("@Carapuce #attack #ecume @bulbizare1"))
		{
			if (owner != question.getScreenName())
			{
				return ( question.getScreenName() + ' ' + carapuce.getOwnerPoke() + " is my owner");
			}
		}
		return null;

		
    }
}
