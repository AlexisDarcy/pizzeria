package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;

public abstract class MenuService {
	public abstract void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws PizzaException;
}
