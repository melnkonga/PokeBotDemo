package gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import scala.actors.threadpool.Arrays;

import com.google.gson.Gson;

public class bdgsonLoading {

	private static int pv = 100;

	public static Object[] findCaracPokemon(String pokemon,
			DataObjectPokemon[] tableau) {
		ArrayList<Object> pokemonStat = new ArrayList<Object>();
		for (int i = 0; i < tableau.length; ++i) {

			if (pokemon.equals(tableau[i].getNom())) {
				pokemonStat.add(tableau[i].getCapspe1());
				pokemonStat.add(tableau[i].getCapspe2());
				pokemonStat.add(tableau[i].getCaptureval());
				pokemonStat.add(tableau[i].getCouleur());
				pokemonStat.add(tableau[i].getEffortval());
				pokemonStat.add(tableau[i].getEspece());
				pokemonStat.add(tableau[i].getExpmax());
				pokemonStat.add(tableau[i].getEffortval());
				pokemonStat.add(tableau[i].getFmratio());
				pokemonStat.add(tableau[i].getForme());
				pokemonStat.add(tableau[i].getPoids());
				pokemonStat.add(tableau[i].getTaille());
				pokemonStat.add(tableau[i].getType1());
				pokemonStat.add(tableau[i].getType2());
			}

		}
		return pokemonStat.toArray();
	}

	public static String[] findAttPokemon(String pokemon,
			DataObjectPokemon[] tableau) {
		for (int i = 0; i < tableau.length; ++i) {

			if (pokemon.equals(tableau[i].getNom())) {
				DataObjectAttack[] tabAtt = tableau[i].getAttaques();
				String[] tab = new String[tabAtt.length];

				for (int j = 0; j < tabAtt.length; j++) {
					tab[j] = tabAtt[j].getNom();

				}
				return tab;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				bdgsonLoading.class.getClassLoader().getResourceAsStream(
						"pokedex.json")));
		DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);

		String str [] = findAttPokemon("Carapuce", obj);
		System.out.println(Arrays.toString(str));
		

	}

	public static int getPv() {
		return pv;
	}

	public static void setPv(int pv) {
		bdgsonLoading.pv = pv;
	}
}