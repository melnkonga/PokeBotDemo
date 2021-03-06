package fr.univaix.iut.pokebattle.progbd;

import static org.fest.assertions.Assertions.assertThat;

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

import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class DAOPokemonJPATest {
   
	private static EntityManager entityManager;
	private static FlatXmlDataSet dataset;
	private static DatabaseConnection dbUnitConnection;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOPokemonJPA dao;

	@BeforeClass
	public static void initTestFixture() throws Exception {
		// Get the entity manager for the tests.
		entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
		entityManager = entityManagerFactory.createEntityManager();    
		dao = new DAOPokemonJPA(entityManager);
		java.sql.Connection connection = ((EntityManagerImpl) (entityManager
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
		List<Pokemon> pokemons = dao.findAll();
		assertThat(pokemons.get(0).getNom()).isEqualTo("Pikachu");
	}

	@Test
	public void testGetById() throws Exception {
		assertThat(dao.getById("Pikachu").getNom()).isEqualTo("Pikachu");
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(dao.getById("Salameche"));
		assertThat(dao.getById("Salameche")).isNull();
	}

	@Test
	public void testInsert() throws Exception {
		Pokemon carapuce = new Pokemon("bulbizar");
		carapuce.setType1("Herbe");
		dao.insert(carapuce);
		assertThat(dao.getById("bulbizar").getNom()).isEqualTo("bulbizar");
		assertThat(dao.getById("bulbizar").getType1()).isEqualTo("Herbe");
	}
	
	  @Test public void testUpdate() throws Exception { 
		  Pokemon pikachu =
	  dao.getById("Pikachu"); 
		 assertThat(pikachu.getPoids()).isGreaterThan(0);
	  pikachu.setPoids(-1); 
	  dao.update(pikachu);
	  assertThat(dao.getById("Pikachu").getPoids()).isLessThan(0); }
	 }