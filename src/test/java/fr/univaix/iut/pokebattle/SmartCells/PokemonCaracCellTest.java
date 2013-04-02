package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonCaracCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracCellTest {
	PokemonCaracCell poke = new PokemonCaracCell ();
	
	@Test
	public void askLevel() {
		assertEquals("@youvannn #level=1 " + new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("youvannn", "@carapuce_bot #stat #level ?")));
	}
	@Test
	public void askXp() {
		assertEquals("@youvannn #XP=0 " + new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("youvannn", "@carapuce_bot #stat #XP ?")));
	}
	
	@Test
	public void askPv() {
		assertEquals("@youvannn #PV=0/100 " + new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("youvannn", "@carapuce_bot #stat #PV ?")));
	}

}
