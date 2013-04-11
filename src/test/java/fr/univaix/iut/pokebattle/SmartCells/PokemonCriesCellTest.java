package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();
 
    @Test
    public void testSalut() {  
        assertEquals("@youvannn sala sala" + " #pokebattle"/*+ new GregorianCalendar().getTime().toString()*/, cell.ask(new Tweet("youvannn","@salameche_bot salut!")));
    }    
    
    @Test
    public void testNotSalut() {
        assertEquals(null, cell.ask(new Tweet("neyo33","@carapuce_bot blabla")));
    }

}