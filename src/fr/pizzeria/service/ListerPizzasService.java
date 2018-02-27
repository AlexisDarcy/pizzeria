package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;
/**
 * Classe permettant l'affichage des pizzas
 * @author Alexis Darcy
 */
public class ListerPizzasService extends MenuService {
	
	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant l'affichage des pizzas
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		System.out.println("Liste des pizzas");
		for(Pizza p : lesPizzas.findAllPizzas()){
				System.out.println(p);
		}
	}
}
