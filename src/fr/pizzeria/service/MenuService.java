package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
/**
 * Classe abstraite MenuService
 * @author Alexis Darcy
 */
public abstract class MenuService {
	/**
	 * Classe abstraite executeUC
	 * @param lesPizzas
	 * @param questionUser
	 * @throws PizzaException
	 */
	public abstract void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws PizzaException;
}
