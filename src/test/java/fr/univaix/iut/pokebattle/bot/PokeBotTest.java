package fr.univaix.iut.pokebattle.bot;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();
    

    @Test
    public void testSalut() {

        assertEquals("@J_apple_junior Skwalop skwalop"+" "+new GregorianCalendar().getTime().toString(), pokeBot.ask(new Tweet("J_apple_junior", "Salut")));
     //   assertEquals(null, pokeBot.ask(new Tweet("J_apple_junior","This is not a question.")));


    }
    

}
