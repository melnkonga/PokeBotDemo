package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonCaracAttackCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonCaracCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaracAttackCellTest {

	PokemonCaracAttackCell poke = new PokemonCaracAttackCell ();
	
	@Test
	public void askAttack() {
		assertEquals("@youvannn #ecume #PP=10/35 " + new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("youvannn", "@carapuce_bot #statAttack #PP #ecume ?")));
		assertEquals("@youvannn attaque inconnue " + new GregorianCalendar().getTime().toString(), poke.ask(new Tweet("youvannn", "@carapuce_bot #statAttack #PP #feu ?")));
	}


}
