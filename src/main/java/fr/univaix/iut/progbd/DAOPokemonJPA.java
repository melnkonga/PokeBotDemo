package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAOPokemonJPA {

    public void insert(Pokemon obj) {
    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("PokemonDB");
           EntityManager em = emf.createEntityManager();
           EntityTransaction tx = em.getTransaction();
           Pokemon carapuce = Pokemon.createPokemon("Carapuce","J_Apple_Junior");
           tx.begin();
           em.persist(carapuce);
           tx.commit();
           System.out.println(carapuce);
           em.close();
           emf.close();
    }
}
