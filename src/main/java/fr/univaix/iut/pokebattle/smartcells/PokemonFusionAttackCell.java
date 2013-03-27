package fr.univaix.iut.pokebattle.smartcells;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import GSON.BDGSONLoading;
import GSON.DataObjectAttack;
import GSON.DataObjectPokemon;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFusionAttackCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		String Resultat = null;
		String nomAttaque = null;
		String nomPokemonAdvsaire = null;
		String nomDressAdv = null;
		String nomPoke=null;
		boolean bonneattaque = false;
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"1nsanesuperstar");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("#attack")) {

			if (owner.equals(question.getScreenName())) {
				String delimiter = " ";
				String[] texteTweet = question.getText().split(delimiter);

				int Cpt = 0;

				for (int i = 0; i < texteTweet.length; ++i) {

					if (texteTweet[i].contains("#attack"))
					{
						Gson gson = new Gson();
 
				        BufferedReader br = new BufferedReader(new InputStreamReader(BDGSONLoading.class.getClassLoader().getResourceAsStream("pokedex.json")));
						nomAttaque = texteTweet[i + 1];
						DataObjectPokemon[] tabatak = gson.fromJson(br, DataObjectPokemon[].class);
						
						nomPoke=carapuce.getNomPoke();
						 
							
						 
							String[] tab =GSON.BDGSONLoading.FindAttPokemon(nomPoke,tabatak);
						for (int j = 0; j < tab.length; j++) {
							
							String delim1="#";
							String[] nomtab1 =nomAttaque.split(delim1);
							 
							
							String  Attaque  = nomtab1[1];
							
							
							if(tab[j].equals(Attaque)) {
								
								bonneattaque=true;
								break;
							}
							
						}
						
						if(!bonneattaque)
								return null;
						
					}

					if (texteTweet[i].contains("@")) {
						++Cpt;
						if (Cpt == 2)
							nomPokemonAdvsaire = texteTweet[i];
						if (Cpt == 3)
							nomDressAdv = texteTweet[i];
					}

				}
				Resultat = nomPokemonAdvsaire + " #attack " + nomAttaque
						+ " /cc " + nomDressAdv + " @"
						+ question.getScreenName() + " @JugeViviane";

				return Resultat;

			} else {
				return ("@" + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner");
			}

		}
		return null;
	}
}
