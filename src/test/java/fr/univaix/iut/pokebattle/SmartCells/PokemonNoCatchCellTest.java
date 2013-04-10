package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonNoCatchCellTest {

	PokemonNoCatchCell pokeBot = new PokemonNoCatchCell();
	
	@Test
	public void testCatch()
	{
		assertEquals("@raph @J_Apple_Junior is my owner #pokebattle "+new GregorianCalendar().getTime().toString(), pokeBot.ask(new Tweet("raph","@carapuce_bot Pokeball")));
	}
	
	@Test
	public void testNull()
	{
		assertEquals(null, pokeBot.ask(new Tweet("raph", "@carapuce_bot Pokepouet")));
	}

}
