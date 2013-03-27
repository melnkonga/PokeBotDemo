package GSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.google.gson.Gson;

import fr.univaix.iut.progbd.Type;

public class BDGSONLoading 
{
	
	private static int pv =100; 
	public static void FindPokemon (String pokemon,DataObjectPokemon[] tableau)
	{
		for (int i = 0; i < tableau.length; ++i)
		{

			if (pokemon.equals(tableau[i].nom))
				System.out.println(tableau[i]);
		}
	}
	
	public static Object[] FindCaracPokemon (String pokemon,DataObjectPokemon[] tableau)
	{
		ArrayList<Object> pokemonStat = new ArrayList<Object>();
		for (int i = 0; i < tableau.length; ++i)
		{
	
			if (pokemon.equals(tableau[i].nom))
			{
				pokemonStat.add(tableau[i].capspe1);
				pokemonStat.add(tableau[i].capspe2);
				pokemonStat.add(tableau[i].captureval);
				pokemonStat.add(tableau[i].couleur);
				pokemonStat.add(tableau[i].effortval);
				pokemonStat.add(tableau[i].espece);
				pokemonStat.add(tableau[i].expmax);
				pokemonStat.add(tableau[i].expval);
				pokemonStat.add(tableau[i].fmratio);
				pokemonStat.add(tableau[i].forme);
				pokemonStat.add(tableau[i].poids);
				pokemonStat.add(tableau[i].taille);
				pokemonStat.add(tableau[i].type1);
				pokemonStat.add(tableau[i].type2);
			}
			
		}
		System.out.println(pokemonStat);
		return pokemonStat.toArray();
	}
	
	public static void FindAttPokemon (String pokemon,DataObjectPokemon[] tableau)
	{
		for (int i = 0; i < tableau.length; ++i)
		{

			if (pokemon.equals(tableau[i].nom))
			{
				DataObjectAttack[] tabAtt= tableau[i].getAttaques();
				for (int j = 0; j < tabAtt.length; ++j) {
					System.out.println(tabAtt[j].nom);
				}
			}
		}
	}

    public static void main( String[] args )
    {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(BDGSONLoading.class.getClassLoader().getResourceAsStream("pokedex.json")));
        DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);

        FindAttPokemon("Carapuce",obj);
        FindCaracPokemon("Carapuce",obj);
    }
}