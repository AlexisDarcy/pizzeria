/**
 * 
 */
package fr.pizzeria.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;

/**
 * @author Alexis Darcy
 *
 */
public class AjouterPizzasServiceTest {

	@Rule public TextFromStandardInputStream systemInMock= emptyStandardInputStream();
	public static IPizzaDao lesPizzas;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lesPizzas = new PizzaMemDao();
		lesPizzas.init();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.pizzeria.service.AjouterPizzasService#executeUC(fr.pizzeria.dao.IPizzaDao, java.util.Scanner)}.
	 */
	@Test
	public void testExecuteUC() {
		systemInMock.provideLines("BOL", "Bolognaise", "15.00", "viande");
		Scanner questionUser = new Scanner(System.in);
		try {
			MenuService mS;
			mS = MenuServiceFactory.getInstance(2);
			mS.executeUC(lesPizzas, questionUser);
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		assertThat(lesPizzas.findAllPizzas().get(lesPizzas.findAllPizzas().size()-1).getCode(), is("BOL"));
		assertThat(lesPizzas.findAllPizzas().get(lesPizzas.findAllPizzas().size()-1).getLibelle(), is("Bolognaise"));
		assertThat(lesPizzas.findAllPizzas().get(lesPizzas.findAllPizzas().size()-1).getPrix(), is(15.00));
		assertThat(lesPizzas.findAllPizzas().get(lesPizzas.findAllPizzas().size()-1).getCategorie(), is(CategoriePizza.VIANDE));
	}
	
	@Test (expected = PizzaException.class)
	public void testExecuteUCPizzaException() throws PizzaException {
		systemInMock.provideLines("PEP", "Bolognaise", "15.00", "viande");
		Scanner questionUser = new Scanner(System.in);

		MenuService mS;
		mS = MenuServiceFactory.getInstance(2);
		mS.executeUC(lesPizzas, questionUser);

	}
	
	@Test(expected = PizzaException.class)
	public void testExecuteUCPrixException() throws PizzaException {
		systemInMock.provideLines("BOL", "Bolognaise", "hdfgfgrfgfr", "viande");
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		mS = MenuServiceFactory.getInstance(2);
		mS.executeUC(lesPizzas, questionUser);

	}
	
	@Test(expected = PizzaException.class)
	public void testExecuteUCCategorieException() throws PizzaException {
		systemInMock.provideLines("4FRO", "4 fromage", "15.00", "fromage");
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		mS = MenuServiceFactory.getInstance(2);
		mS.executeUC(lesPizzas, questionUser);

	}
	
	@Test(expected = PizzaException.class)
	public void testExecuteUCNullException() throws PizzaException {
		systemInMock.provideLines(null, null, null, null);
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		mS = MenuServiceFactory.getInstance(2);
		mS.executeUC(lesPizzas, questionUser);

	}


}
