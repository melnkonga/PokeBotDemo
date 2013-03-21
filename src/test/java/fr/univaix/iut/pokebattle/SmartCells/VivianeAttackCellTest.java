package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.VivianeAttackCells;

public class VivianeAttackCellTest {

	VivianeAttackCells ce= new VivianeAttackCells();
	
	@Test
	public void testviv() {
		assertEquals("@salameche_bot -10 pv /cc @1nsanesuperstar", ce.ask(new Tweet("1nsanesuperstar", "@carapuce_bot #attack #charge @salameche_bot /cc @nedseb  @JugeViviane")));
	}

}
