package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonNoCatchCell implements SmartCell {
	
	public String ask(Tweet question) {
		
		Pokemon cara = new Pokemon("carapuce","Skwalop Skwalop","@J_Apple_Junior", "null");
		
		if (question.getText().contains("@carapuce Pokeball"))
		{
			String S = question.getScreenName()+' '+cara.getOwnerPoke()+" is my owner";
			return S;
		}
		
		return null;
	}

}
