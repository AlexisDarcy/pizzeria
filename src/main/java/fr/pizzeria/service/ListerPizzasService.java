package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.ListerPizzaException;
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
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws ListerPizzaException {
		System.out.println("Liste des pizzas");
		List<Pizza> listePizzas = lesPizzas.findAllPizzas();
		if (listePizzas != null) {
			if(!listePizzas.isEmpty()){
				for(Pizza p : listePizzas){
					System.out.println(p);
				}
			}else{
				throw new ListerPizzaException("La liste est vide");
			}
		} else {
			throw new ListerPizzaException("La liste est null");
		}
	}
}
