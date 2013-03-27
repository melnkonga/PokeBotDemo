package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackCellTest {
	PokemonAttackCell pok = new PokemonAttackCell();
	@Test
	public void testAttack() {
		// assertEquals("@bulbizare #attack #foudre //cc @youvann @JugeViviane", pok.ask(new Tweet("youvann", "@pikachu #attack #foudre @bulbizare @JugeViviane")));

		 assertEquals("@bulbizare #attack #foudre //cc @youvann", pok.ask(new Tweet("youvann", "@pikachu #attack #foudre @bulbizare")));
	}

}
