package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonPertePvCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		if (question.getText().contains("-10 pv")){
			
		}
		return null;
	}

}
