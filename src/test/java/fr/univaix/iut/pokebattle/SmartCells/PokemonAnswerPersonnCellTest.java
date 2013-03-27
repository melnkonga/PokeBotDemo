package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerPersonCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerPersonnCellTest {
	PokemonAnswerPersonCell pk = new PokemonAnswerPersonCell();
	
	@Test
	public void TestSalut(){
        assertEquals("@youvannn Skwalop skwalop"+ " "+ new GregorianCalendar().getTime().toString(), pk.ask(new Tweet("youvannn", "@carapuce Salut!")));
	}
}
