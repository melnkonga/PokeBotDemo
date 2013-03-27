package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokeWinnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeWinnerCellTest {
	PokeWinnerCell poke = new PokeWinnerCell();
	@Test
	public void test() {
		assertEquals("@carapuce_bot #win", poke.ask(new Tweet("salameche_bot", "#KO /cc @JugeViviane @youvannn @1nsanesuperstar")));
	}
}
