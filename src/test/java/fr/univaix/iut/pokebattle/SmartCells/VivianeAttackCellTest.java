package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.VivianeAttackCells;

public class VivianeAttackCellTest {

	VivianeAttackCells ce= new VivianeAttackCells();
	
	@Test
	public void testviv() {
		assertEquals("@salameche -10 pv /cc @pcreux", ce.ask(new Tweet("carapuce_bot", "@salameche #attack #charge /cc @nedseb @pcreux @JugeViviane")));
	}

}
