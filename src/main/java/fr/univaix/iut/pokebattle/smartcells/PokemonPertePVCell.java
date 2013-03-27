package fr.univaix.iut.pokebattle.smartcells;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonPertePVCell implements SmartCell{
	
	public String ask(Tweet question) {
		String Resultat = null;
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop", "1nsanesuperstar");
		String owner = carapuce.getOwnerPoke();
		carapuce.setPV(10);
		
		if ((question.getScreenName()).equals("JugeViviane")) {
			
			if (question.getText().contains("-10pv")) {
				carapuce.setPV(carapuce.getPV()-10);
				if (carapuce.getPV()==0) {
					Resultat = "#KO /cc @JugeViviane @" + owner;
				}
			}
		
		}
		return Resultat;
	}
	

}
