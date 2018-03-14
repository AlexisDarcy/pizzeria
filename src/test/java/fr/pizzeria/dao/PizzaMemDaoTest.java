/**
 * 
 */
package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Alexis Darcy
 *
 */
public class PizzaMemDaoTest {

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
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#init()}.
	 */
	@Test
	public void testInit() {
		assertEquals(8, lesPizzas.findAllPizzas().size());
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#findAllPizzas()}.
	 */
	@Test
	public void testFindAllPizzas() {
		lesPizzas.saveNewPizza(new Pizza("VEG", "Vegetarien", 15.00, CategoriePizza.SANS_VIANDE));
		lesPizzas.saveNewPizza(new Pizza("BOL", "Bolognaise", 15.00, CategoriePizza.VIANDE));
		
		assertEquals(10, lesPizzas.findAllPizzas().size());			
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#saveNewPizza(fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testSaveNewPizza() {
		lesPizzas.saveNewPizza(new Pizza("VEG", "Vegetarien", 15.00, CategoriePizza.SANS_VIANDE));
		lesPizzas.saveNewPizza(new Pizza("BOL", "Bolognaise", 13.00, CategoriePizza.VIANDE));
		
		assertThat(lesPizzas.findAllPizzas().get(8).getCode(), is("VEG"));
		assertThat(lesPizzas.findAllPizzas().get(9).getCode(), is("BOL"));
		assertThat(lesPizzas.findAllPizzas().get(8).getLibelle(), is("Vegetarien"));
		assertThat(lesPizzas.findAllPizzas().get(9).getLibelle(), is("Bolognaise"));
		assertThat(lesPizzas.findAllPizzas().get(8).getPrix(), is(15.00));
		assertThat(lesPizzas.findAllPizzas().get(9).getPrix(), is(13.00));
		assertThat(lesPizzas.findAllPizzas().get(8).getCategorie(), is(CategoriePizza.SANS_VIANDE));
		assertThat(lesPizzas.findAllPizzas().get(9).getCategorie(), is(CategoriePizza.VIANDE));
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)}.
	 */
	@Test
	public void testUpdatePizza() {
		lesPizzas.saveNewPizza(new Pizza("Bolo", "Bolognaie", 23.00, CategoriePizza.SANS_VIANDE));
		lesPizzas.updatePizza("Bolo", new Pizza("BOL", "Bolognaise", 13.00, CategoriePizza.VIANDE));

		assertThat(lesPizzas.findAllPizzas().get(8).getCode(), is("BOL"));
		assertThat(lesPizzas.findAllPizzas().get(8).getLibelle(), is("Bolognaise"));
		assertThat(lesPizzas.findAllPizzas().get(8).getPrix(), is(13.00));
		assertThat(lesPizzas.findAllPizzas().get(8).getCategorie(), is(CategoriePizza.VIANDE));		
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#deletePizza(java.lang.String)}.
	 */
	@Test
	public void testDeletePizza() {
		lesPizzas.deletePizza("FRO");
		assertEquals(7, lesPizzas.findAllPizzas().size());
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#findPizzaByCode(java.lang.String)}.
	 */
	@Test
	public void testFindPizzaByCode() {
		Pizza pizza =  lesPizzas.findPizzaByCode("CAN");
		assertNotNull(pizza);
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#pizzaExists(java.lang.String)}.
	 */
	@Test
	public void testPizzaExists() {
		assertTrue(lesPizzas.pizzaExists("FRO"));
	}

	/**
	 * Test method for {@link fr.pizzeria.dao.PizzaMemDao#categorieExists(fr.pizzeria.model.CategoriePizza)}.
	 */
	@Test
	public void testCategorieExists() {
		assertTrue(lesPizzas.categorieExists("VIANDE"));
	}

}
