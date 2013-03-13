package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Tweet;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;

public class PokemonOwnerTestCell {
	
	 PokemonOwnerCell owner = new PokemonOwnerCell();
	
    @Test
    public void testOwner()
	{
		assertEquals("@nedseb @J_Apple_Junior is my owner", owner.ask(new Tweet("nedseb", "owner")));
	}


}
