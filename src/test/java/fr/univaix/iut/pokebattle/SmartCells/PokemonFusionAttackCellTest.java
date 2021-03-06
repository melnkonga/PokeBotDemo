package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonFusionAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFusionAttackCellTest {
	PokemonFusionAttackCell poke = new PokemonFusionAttackCell();

	@Test
	public void TestAttack() {
		assertEquals(
				"@bulbizare #attack #Morsure /cc @nedseb @1nsanesuperstar @JugeViviane"
						+ " " + new GregorianCalendar().getTime().toString(),
				poke.ask(new Tweet("1nsanesuperstar",
						"@Carapuce #attack #Morsure @bulbizare /cc @nedseb @JugeViviane")));
	}

	@Test
	// lkok
	public void TestAttack2() {
		assertEquals(
				"@1nsanesuperstar o_O ? /cc @nedseb @JugeViviane @bulbizare"
						+ " " + new GregorianCalendar().getTime().toString(),
				poke.ask(new Tweet("1nsanesuperstar",
						"@Carapuce #attack #Islande @bulbizare /cc @nedseb @JugeViviane")));
	}

	@Test
	public void TestOwner() {
		assertEquals("@raph @1nsanesuperstar is my owner" + " "
				+ new GregorianCalendar().getTime().toString(),
				poke.ask(new Tweet("raph",
						"@Carapuce #attack #ecume @bulbizare")));
	}
}
