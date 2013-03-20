package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerOnlyOwnerCell;

public class PokemonAnswerOnlyOwnerCellTest {

	@Test
	public void test() {
		PokemonAnswerOnlyOwnerCell bot=new PokemonAnswerOnlyOwnerCell();
		assertEquals("@raph @J_Apple_Junior is my owner",  bot.ask(new Tweet("raph","@Carapuce #attack #ecume @bulbizare1")));
	}


}


