package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		DAOPokemonJPA daopok = new DAOPokemonJPA(em);
		DAODresseur daoDresseur = new DAODresseur(em);
		DAOPokeBotJPA daoBotJPA = new DAOPokeBotJPA(em);

		fr.univaix.iut.progbd.Pokemon pok = new fr.univaix.iut.progbd.Pokemon(
				"Carapuce");
		pok.setCri("skwalop skwalop");
		PokeBot p = new PokeBot("carapuce_bot");
		Dresseur d = new Dresseur("J_Apple_Junior");
		p.setOwner(d);
		p.setTypePokemon(pok);
		daopok.insert(pok);
		daoDresseur.insert(d);
		daoBotJPA.insert(p);

		PokeBot bot = daoBotJPA.getById("carapuce_bot");
		bot.setPv(1);
		daoBotJPA.update(bot);
		
		fr.univaix.iut.progbd.Pokemon pok2 = new fr.univaix.iut.progbd.Pokemon(
				"Salameche");
		pok2.setCri("sala sala");
		PokeBot p2 = new PokeBot("salameche_bot");
		p2.setOwner(null);
		p2.setTypePokemon(pok2);
		daopok.insert(pok2);
		daoBotJPA.insert(p2);

		PokeBot bot2 = daoBotJPA.getById("salameche_bot");
		bot2.setPv(1);
		daoBotJPA.update(bot2);
	
		
	}
}
