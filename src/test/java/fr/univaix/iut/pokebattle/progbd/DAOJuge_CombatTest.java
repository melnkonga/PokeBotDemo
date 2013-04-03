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

import fr.univaix.iut.progbd.DAOJuge_Combat;
import fr.univaix.iut.progbd.Juge_Combat;
import fr.univaix.iut.progbd.Pokemon;

public class DAOJuge_CombatTest {

	private static EntityManager entityManager;
	private static FlatXmlDataSet dataset;
	private static DatabaseConnection dbUnitConnection;
	private static EntityManagerFactory entityManagerFactory;
	private static DAOJuge_Combat dao;
	
	@BeforeClass
	public static void initTestFixture() throws Exception {
		// Get the entity manager for the tests.
		entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
		entityManager = entityManagerFactory.createEntityManager();
		dao = new DAOJuge_Combat(entityManager);
		java.sql.Connection connection = ((EntityManagerImpl) (entityManager
				.getDelegate())).getServerSession().getAccessor()
				.getConnection();

		dbUnitConnection = new DatabaseConnection(connection);
		// Loads the data set from a file
		dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("Juge_CombatDataset.xml"));
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
		dao.delete(dao.getById("JugeViviane"));
		assertThat(dao.getById("JugeViviane")).isNull();
	}
	
	@Test
	public void testGetById() throws Exception {
		assertThat(dao.getById("JugeViviane").getNom()).isEqualTo("JugeViviane");
	}
	
	@Test
	public void testInsert() throws Exception {
		Juge_Combat juge = new Juge_Combat("JugeRaphael");
		dao.insert(juge);
		assertThat(dao.getById("JugeRaphael").getNom()).isEqualTo("JugeRaphael");
	}
}
