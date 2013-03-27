package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonFusionAttackCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonPertePVCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonPertePVCellTest {

	PokemonPertePVCell poke = new PokemonPertePVCell();
	
	@Test
	public void TestPertePV(){
		assertEquals("#KO /cc @JugeViviane @1nsanesuperstar", poke.ask(new Tweet("JugeViviane", "@carapuce -10pv /cc @1nsanesuperstar")));
	}
	

}
