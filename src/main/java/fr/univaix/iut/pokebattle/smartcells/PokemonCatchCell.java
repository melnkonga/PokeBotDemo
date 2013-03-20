package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonCatchCell implements SmartCell {

	

	public String ask(Tweet question) {
		
		Pokemon cara=new Pokemon("carapuce","skwalop");
		if (question.getText().contains("Pokeball"))
		{
			cara.setOwnerPoke(question.getScreenName());
			String S= "@"+question.getScreenName()+" @"+cara.getOwnerPoke() +" is my owner";
			
			return S;
		}
		
		return null;
		
		
		
	}

}
