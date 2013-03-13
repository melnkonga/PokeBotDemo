package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokeballCell implements SmartCell {

	

	public String ask(Tweet question) {
		
		if (question.getText().contains("@carapuce Pokeball"))
		{
			Pokemon cara=new Pokemon("carapuce","skwalop");
			String S= question.getScreenName()+" is my owner";
			cara.setOwnerPoke(question.getScreenName());
			return S;
		}
		
		return null;
		
		
		
	}

}
