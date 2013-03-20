package fr.univaix.iut.pokebattle.SmartCells;



import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;

import fr.univaix.iut.pokebattle.smartcells.PokemonCatchCell;

public class PokemonCatchCellTestCase {

    @Test
    public void testPokeball()
    {
    	
    	PokemonCatchCell pokeBot=new PokemonCatchCell();
		assertEquals("@raph is my owner", pokeBot.ask(new Tweet("raph","@carapuce Pokeball")));
    }

}
