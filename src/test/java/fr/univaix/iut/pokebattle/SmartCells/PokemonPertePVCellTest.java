package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonPertePVCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonPertePVCellTest {

	PokemonPertePVCell poke = new PokemonPertePVCell();
	
	@Test
	public void TestPertePV(){
		assertEquals("#KO /cc @JugeViviane @J_Apple_Junior #pokebattle "+new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("JugeViviane", "@carapuce_bot -10pv /cc @1nsanesuperstar")));
	}
	
	@Test
	public void TestPertePV2(){
		assertEquals(null, poke.ask(new Tweet("JugeViviane", "@carapuce_bot -20pv /cc @1nsanesuperstar")));
	}
	
}
