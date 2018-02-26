package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class QuitterPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		System.out.println("Aurevoir ☹");
	}

}
