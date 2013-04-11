package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonNoCatchCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAODresseur;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonNoCatchCellTest {

	PokemonNoCatchCell pokeBot = new PokemonNoCatchCell();
	
	@Test
	public void testNoCatch()
	{  
		assertEquals("@raph @youvannn is my owner #pokebattle "/*+new GregorianCalendar().getTime().toString()*/, pokeBot.ask(new Tweet("raph","@carapuce_bot Pokeball")));
	}  
	
	@Test
	public void testCatch()
	{    
		assertEquals("@1nsanesuperstar @1nsanesuperstar is my owner #pokebattle "/*+new GregorianCalendar().getTime().toString()*/, pokeBot.ask(new Tweet("1nsanesuperstar","@salameche_bot Pokeball")));
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");  
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);
		DAODresseur daoDressJPA = new DAODresseur(em);
	    PokeBot pokebot = daoBotJPA.getById("salameche_bot");
		pokebot.setOwner(null);
		daoBotJPA.update(pokebot);
	}  
	
	
	@Test
	public void testNull()
	{
		assertEquals(null, pokeBot.ask(new Tweet("raph", "@carapuce_bot Pokepouet")));
	}

}
