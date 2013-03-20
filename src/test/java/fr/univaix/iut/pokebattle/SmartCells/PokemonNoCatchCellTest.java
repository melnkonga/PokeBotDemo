package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;

public class PokemonNoCatchCellTest {

	@Test
	public void test()
	{
		PokemonNoCatchCell pokeBot = new PokemonNoCatchCell();
		assertEquals("@raph @J_Apple_Junior is my owner", pokeBot.ask(new Tweet("@raph","@carapuce Pokeball")));
	}

}
