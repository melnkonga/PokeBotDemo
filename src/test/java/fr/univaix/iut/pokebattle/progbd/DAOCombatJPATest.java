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

import fr.univaix.iut.progbd.Combat;
import fr.univaix.iut.progbd.DAOCombatJPA;
import fr.univaix.iut.progbd.Dresseur;
import fr.univaix.iut.progbd.Juge_Combat;
import fr.univaix.iut.progbd.PokeBot;
import fr.univaix.iut.progbd.Pokemon;

public class DAOCombatJPATest {
    
	private static EntityManager entityManager;
	private static FlatXmlDataSet dataset;
	private static DatabaseConnection dbUnitConnection;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOCombatJPA dao;

	@BeforeClass  
	public static void initTestFixture() throws Exception {
		// Get the entity manager for the tests.
		entityManagerFactory = Persistence
				.createEntityManagerFactory("pokebattlePUTest");
		entityManager = entityManagerFactory.createEntityManager();

		dao = new DAOCombatJPA(entityManager);

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
		List<Combat> combat = dao.findAll();
		assertThat(combat.get(0).getIdcombat()).isEqualTo(1);
	}
	

	@Test
	public void testGetById() throws Exception {
		assertThat(dao.getById(1).getIdcombat()).isEqualTo(1);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(dao.getById(1));
		assertThat(dao.getById(1)).isNull();
	}

	@Test
	public void testInsert() throws Exception {
		PokeBot bot = new PokeBot("pikachu_bot2");
		Pokemon type = new Pokemon("Pikachu");
		Dresseur dress=new Dresseur("J_Apple_Junior");
		bot.setOwner(dress);
		bot.setTypePokemon(type);
		
		PokeBot pokbot = new PokeBot("carapuce_bot");
		Pokemon poke = new Pokemon("Carapuce");
		Dresseur dress2=new Dresseur("youvannn");
		Juge_Combat juge =new Juge_Combat("JugeViviane");
		pokbot.setOwner(dress2);
		pokbot.setTypePokemon(poke)
		
		;
		Combat combat=new Combat(2,"arenedesiles",juge , pokbot, bot);
		
		dao.insert(combat);		
		assertThat(dao.getById(2).getIdcombat()).isEqualTo(2);
	}
	
}
	


