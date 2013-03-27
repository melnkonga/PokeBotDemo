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
	
	public static String[] FindAttPokemon (String pokemon,DataObjectPokemon[] tableau)
	{
		for (int i = 0; i < tableau.length; ++i)
		{

			if (pokemon.equals(tableau[i].nom))
			{
				DataObjectAttack[] tabAtt= tableau[i].getAttaques();
				String[] Tab = new String[tabAtt.length];
				
				for (int j = 0; j < tabAtt.length; j++) {
					Tab[j]=tabAtt[j].nom;
					
				}
				return Tab;
			}
		}
		return null;
	}

    public static void main( String[] args )
    {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(BDGSONLoading.class.getClassLoader().getResourceAsStream("pokedex.json")));
        DataObjectPokemon[] obj = gson.fromJson(br, DataObjectPokemon[].class);
        
        String[] tab=FindAttPokemon("Carapuce",obj);
        for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}
        
    }
}