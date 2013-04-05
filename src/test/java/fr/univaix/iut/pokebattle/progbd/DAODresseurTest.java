package fr.univaix.iut.pokebattle.progbd;

import static org.fest.assertions.Assertions.assertThat;

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

import fr.univaix.iut.progbd.DAODresseur;
import fr.univaix.iut.progbd.Dresseur;

public class DAODresseurTest {

	private static EntityManager entityManager;
	private static FlatXmlDataSet dataset;
	private static DatabaseConnection dbUnitConnection;
	private static EntityManagerFactory entityManagerFactory;
	private static DAODresseur dao;
	
	@BeforeClass  
	public static void initTestFixture() throws Exception {
		// Get the entity manager for the tests.
		entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
	    	entityManager = entityManagerFactory.createEntityManager();
		dao = new DAODresseur(entityManager);
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
	public void delete() throws Exception {
		dao.delete(dao.getById("J_Apple_Junior"));
		assertThat(dao.getById("J_Apple_Junior")).isNull();
	}
	
	@Test
	public void testGetById() throws Exception {
		assertThat(dao.getById("J_Apple_Junior").getNom()).isEqualTo("J_Apple_Junior");
	}
	
	@Test
	public void testInsert() throws Exception {
		Dresseur dresseur = new Dresseur("Insane");
		dao.insert(dresseur);
		assertThat(dao.getById("Insane").getNom()).isEqualTo("Insane");
	}
	
}
