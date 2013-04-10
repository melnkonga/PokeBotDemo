package fr.univaix.iut.pokebattle.smartcells;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import gson.DataObjectPokemon;
import gson.bdgsonLoading;

public class PokemonFusionAttackCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		String resultat = null;
		String nomAttaque = null;
		String nomPokemonAdvsaire = null;
		String nomDressAdv = null;
		String nomPoke = null;
		boolean bonneattaque = false;
		Pokemon carapuce = new Pokemon("Carapuce", "Skwalop Skwalop",
				"1nsanesuperstar");
		String owner = carapuce.getOwnerPoke();

		if (question.getText().contains("#attack")) {

			if (owner.equals(question.getScreenName())) {
				String delimiter = " ";
				String[] texteTweet = question.getText().split(delimiter);

				int cpt = 0;

				for (int i = 0; i < texteTweet.length; ++i) {

					if (texteTweet[i].contains("#attack")) {
						Gson gson = new Gson();

						BufferedReader br = new BufferedReader(
								new InputStreamReader(bdgsonLoading.class
										.getClassLoader().getResourceAsStream(
												"pokedex.json")));
						nomAttaque = texteTweet[i + 1];
						DataObjectPokemon[] tabatak = gson.fromJson(br,
								DataObjectPokemon[].class);

						nomPoke = carapuce.getNomPoke();

						String[] tab = bdgsonLoading.findAttPokemon(
								nomPoke, tabatak);
						for (int j = 0; j < tab.length; j++) {

							String delim1 = "#";
							String[] nomtab1 = nomAttaque.split(delim1);

							String attaque = nomtab1[1];

							if (tab[j].equals(attaque)) {

								bonneattaque = true;
								break;
							}

						}

					}

					if (texteTweet[i].contains("@")) {
						++cpt;
						if (cpt == 2) {
							nomPokemonAdvsaire = texteTweet[i];
						}
						if (cpt == 3) {
							nomDressAdv = texteTweet[i];
						}
					}

				}

				if (bonneattaque) {
					resultat = nomPokemonAdvsaire + " #attack " + nomAttaque
							+ " /cc " + nomDressAdv + " @"
							+ question.getScreenName() + " @JugeViviane" + " "
							+ new GregorianCalendar().getTime().toString();

				} else {
					resultat = "@" + question.getScreenName() + " o_O ?"
							+ " /cc " + nomDressAdv + " @JugeViviane "
							+ nomPokemonAdvsaire + " "
							+ new GregorianCalendar().getTime().toString();
				}

				return resultat;

			} else {
				return ("@" + question.getScreenName() + " @"
						+ carapuce.getOwnerPoke() + " is my owner" + " " + new GregorianCalendar()
						.getTime().toString());
			}

		}
		return null;
	}
}
