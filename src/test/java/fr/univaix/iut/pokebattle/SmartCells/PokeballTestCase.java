package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokeballCell;

public class PokeballTestCase {

    @Test
    public void testPokeball()
    {
    	
    	PokeballCell pokeBot=new PokeballCell();
		assertEquals("@raph is my owner", pokeBot.ask(new Tweet("@raph","@carapuce Pokeball")));
    }

}
