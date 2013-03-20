package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonNameAdverseAttackCell;

public class PokemonNameAdverseAttackCellTest {

	@Test
	public void test() {
		PokemonNameAdverseAttackCell pokeBot = new PokemonNameAdverseAttackCell();
		assertEquals("@pikachu #attack #ecume /cc @raph @J_Apple_Junior", pokeBot.ask(new Tweet("@J_Apple_Junior","@carapuce #attack #ecume @pikachu /cc @raph")));
	}

}