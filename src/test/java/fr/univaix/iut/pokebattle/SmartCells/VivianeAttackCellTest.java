package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.VivianeAttackCells;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class VivianeAttackCellTest {

	VivianeAttackCells ce= new VivianeAttackCells();
	
	@Test
	public void testviv() {
		assertEquals("@salameche_bot -10 pv /cc @pcreux"+" "+new GregorianCalendar().getTime().toString(), ce.ask(new Tweet("carapuce_bot", "@salameche_bot #attack #charge  /cc @nedseb @pcreux  @JugeViviane")));
	}

}
