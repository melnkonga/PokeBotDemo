package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAODresseur;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonOwnerTestCell {
	
	PokemonOwnerCell owner = new PokemonOwnerCell();	
	
    @Test
    public void testOwner()
    {
    	assertEquals("@nedseb @youvannn is my owner #pokebattle" /*+ new GregorianCalendar().getTime().toString()*/, owner.ask(new Tweet("nedseb", "@carapuce_bot owner")));
	}
    
    @Test
    public void testNoOwner()
    {
    	assertEquals("@nedseb no owner", owner.ask(new Tweet("nedseb", "@salameche_bot owner")));
    	
    	
    }
    
    @Test
    public void testNull()
    {
    	assertEquals(null, owner.ask(new Tweet("nedseb", "@salameche_bot hey")));
    }
}
