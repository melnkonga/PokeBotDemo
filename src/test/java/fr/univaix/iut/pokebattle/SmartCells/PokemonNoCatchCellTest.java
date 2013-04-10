package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonNoCatchCellTest {

	@Test
	public void test()
	{
		PokemonNoCatchCell pokeBot = new PokemonNoCatchCell();
		assertEquals("@raph @J_Apple_Junior is my owner"+" "+new GregorianCalendar().getTime().toString(), pokeBot.ask(new Tweet("raph","@carapuce_bot Pokeball")));
	} 
	 

	

}
