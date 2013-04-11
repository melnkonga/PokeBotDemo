package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcells.PokemonPertePVCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAODresseur;
import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.PokeBot;

public class PokemonPertePVCellTest {

	PokemonPertePVCell poke = new PokemonPertePVCell();
	
	@Test
	public void TestPertePV(){
		assertEquals("#KO /cc @JugeViviane @youvannn #pokebattle "/*+new GregorianCalendar().getTime().toString()*/, poke.ask(new Tweet("JugeViviane", "@carapuce_bot -10pv /cc @youvannn")));
	
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");  
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);
		DAODresseur daoDressJPA = new DAODresseur(em);
	    PokeBot pokebot = daoBotJPA.getById("carapuce_bot");
		pokebot.setPv(pokebot.getPv() + 10);
		daoBotJPA.update(pokebot);
		
	
	}
	
	

	
	@Test
	public void TestPertePV2(){
		assertEquals(null, poke.ask(new Tweet("JugeViviane", "@carapuce_bot -20pv /cc @1nsanesuperstar")));
	}
	
	@Test
	public void TestPertePV3(){
		assertEquals(null, poke.ask(new Tweet("JugeViviane", "@salameche_bot -10pv /cc @1nsanesuperstar")));
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");  
		EntityManager em = emf.createEntityManager();
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);
		DAODresseur daoDressJPA = new DAODresseur(em);
	    PokeBot pokebot = daoBotJPA.getById("salameche_bot");
		pokebot.setPv(pokebot.getPv() + 10);
		daoBotJPA.update(pokebot);
	}
	
}
