package fr.univaix.iut.pokebattle.progbd;

import static org.fest.assertions.Assertions.assertThat;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univaix.iut.progbd.DAOPokeBotJPA;
import fr.univaix.iut.progbd.Dresseur;
import fr.univaix.iut.progbd.PokeBot;
import fr.univaix.iut.progbd.Pokemon;

public class DAOPokeBotJPATest {
    
	private static EntityManager entityManager;
	private static FlatXmlDataSet dataset;
	private static DatabaseConnection dbUnitConnection;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOPokeBotJPA dao;

	@BeforeClass  
	public static void initTestFixture() throws Exception {
		// Get the entity manager for the tests.
		entityManagerFactory = Persistence
				.createEntityManagerFactory("pokebattlePUTest");
		entityManager = entityManagerFactory.createEntityManager();

		dao = new DAOPokeBotJPA(entityManager);

		Connection connection = ((EntityManagerImpl) (entityManager
				.getDelegate())).getServerSession().getAccessor()
				.getConnection();

		dbUnitConnection = new DatabaseConnection(connection);
		// Loads the data set from a file
		dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("PokebatleDataset.xml"));
	}

	@AfterClass
	public static void finishTestFixture() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}
   
	@Before
	public void setUp() throws Exception {
		// Clean the data from previous test and insert new data test.
		DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
	}
	
	
	@Test
	public void testFindAll() throws Exception {
		List<PokeBot> pokebot = dao.findAll();
		assertThat(pokebot.get(0).getNom()).isEqualTo("carapuce_bot");
	}
	

	@Test
	public void testGetById() throws Exception {
		assertThat(dao.getById("carapuce_bot").getNom()).isEqualTo("carapuce_bot");
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(dao.getById("carapuce_bot"));
		assertThat(dao.getById("carapuce_bot")).isNull();
	}

	@Test
	public void testInsert() throws Exception {
		PokeBot Salameche_bot = new PokeBot("pikachu_bot");
		Pokemon cara = new Pokemon("Pikachu");
		Dresseur dress=new Dresseur("youvannn");
		Salameche_bot.setOwner(dress);
		Salameche_bot.setTypePokemon(cara);
		
		dao.insert(Salameche_bot);		
		assertThat(dao.getById("pikachu_bot").getNom()).isEqualTo("pikachu_bot");
	}
	/*
	@Test public void testUpdate() throws Exception { 
		  PokeBot bot = dao.getById("carapuce_bot");
	  assertThat(bot.getPv()).isGreaterThan(0);
	  bot.setPv(10); 
	  dao.update(bot);
	  assertThat(dao.getById("carapuce_bot").getPv()).isLessThan(50); 
	  }*/
}
	

