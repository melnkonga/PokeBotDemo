package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("@neyo33 skwalop skwalop", cell.ask(new Tweet("neyo33","@carapuce_bot Salut!")));
    }
    
    @Test
    public void testNotSalut() {
        assertEquals(null, cell.ask(new Tweet("neyo33","@carapuce_bot blabla")));
    }

}