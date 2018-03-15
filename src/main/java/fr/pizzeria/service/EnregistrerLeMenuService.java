/**
 * 
 */
package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;

/**
 * @author Alexis Darcy
 *
 */
public class EnregistrerLeMenuService extends MenuService {

	/* (non-Javadoc)
	 * @see fr.pizzeria.service.MenuService#executeUC(fr.pizzeria.dao.IPizzaDao, java.util.Scanner)
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws PizzaException {
		lesPizzas.init();		
	}

}
