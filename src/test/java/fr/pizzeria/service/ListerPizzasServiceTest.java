/**
 * 
 */
package fr.pizzeria.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.PizzaException;

/**
 * @author Alexis Darcy
 *
 */
public class ListerPizzasServiceTest {
	
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.pizzeria.service.ListerPizzasService#executeUC(fr.pizzeria.dao.IPizzaDao, java.util.Scanner)}.
	 */
	@Test
	public void testExecuteUC() {
		IPizzaDao lesPizzas = new PizzaMemDao();
		lesPizzas.init();
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		try {
			mS = MenuServiceFactory.getInstance(1);
			mS.executeUC(lesPizzas, questionUser);
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			fail("une erreur est survrnue");
		}	
	}
	
	@Test(expected = PizzaException.class)
	public void testExecuteUCListeNull() throws PizzaException {
		IPizzaDao lesPizzas = Mockito.mock(IPizzaDao.class);
		Mockito.when(lesPizzas.findAllPizzas()).thenReturn(null);
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		mS = MenuServiceFactory.getInstance(1);
		mS.executeUC(lesPizzas, questionUser);	
	}
	
	@Test(expected = PizzaException.class)
	public void testExecuteUCListeVide() throws PizzaException {
		IPizzaDao lesPizzas = Mockito.mock(IPizzaDao.class);
		Mockito.when(lesPizzas.findAllPizzas()).thenReturn(new ArrayList<>());
		Scanner questionUser = new Scanner(System.in);
		MenuService mS;
		mS = MenuServiceFactory.getInstance(1);
		mS.executeUC(lesPizzas, questionUser);	
	}

}
