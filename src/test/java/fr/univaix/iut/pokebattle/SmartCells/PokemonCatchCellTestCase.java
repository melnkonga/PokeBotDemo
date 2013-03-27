package fr.univaix.iut.pokebattle.SmartCells;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonCatchCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCatchCellTestCase {

    @Test
    public void testPokeball()
    {
    	
    	PokemonCatchCell pokeBot=new PokemonCatchCell();

		assertEquals("@raph @raph is my owner", pokeBot.ask(new Tweet("raph","@carapuce Pokeball")));


    }

}
