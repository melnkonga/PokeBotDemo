package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerTestCell {
	
	PokemonOwnerCell owner = new PokemonOwnerCell();	
	
    @Test
    public void testOwner()
    {
    	assertEquals("@nedseb @J_Apple_Junior is my owner", owner.ask(new Tweet("nedseb", "@carapuce_bot owner")));
	}
    
    @Test
    public void testNoOwner()
    {
    	assertEquals("@nedseb no owner", owner.ask(new Tweet("nedseb", "@salameche_bot owner")));
    }
}
