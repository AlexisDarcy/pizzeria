package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
/**
 * Classe permettant de quitter l'application
 * @author Alexis Darcy
 */
public class QuitterPizzaService extends MenuService {

	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant de quitter l'application
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		System.out.println("Aurevoir ☹");
	}

}
