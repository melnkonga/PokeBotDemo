package GSON;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BDGSONLoading 
{
	public static void FindPokemon (String pokemon,DataObjectPokemon[] tableau)
	{
		for (int i = 0; i < tableau.length; ++i)
		{

			if (pokemon.equals(tableau[i].nom))
				System.out.println(tableau[i]);
		}
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

        FindAttPokemon("Coconfort",obj);
    }
}