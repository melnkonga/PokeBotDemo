package GSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;



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