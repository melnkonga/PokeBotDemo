package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.DresseurAnswerCombatCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class DresseurAnswerCombatCellTest {

	@Test
	public void test() {
		DresseurAnswerCombatCell bot=new DresseurAnswerCombatCell();
		assertEquals("@neyo33 #fight #ok with @salameche /cc @JugeViviane",  
				bot.ask(new Tweet("neyo33","@sacha_bot1 #fight with @carapuce /cc @JugeViviane")));
	}
}

