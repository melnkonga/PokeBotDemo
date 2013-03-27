package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.VivianeAttackCells;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class VivianeAttackCellTest {

	VivianeAttackCells ce= new VivianeAttackCells();
	
	@Test
	public void testviv() {
		assertEquals("@salameche_bot -10 pv /cc @1nsanesuperstar", ce.ask(new Tweet("1nsanesuperstar", "@carapuce_bot #attack #charge @salameche_bot /cc @nedseb  @JugeViviane")));
	}

}
