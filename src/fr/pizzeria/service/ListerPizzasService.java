package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.controleur.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		System.out.println("Liste des pizzas");
		for(Pizza p : lesPizzas.findAllPizzas()){
				System.out.println(p);
		}
	}
}
