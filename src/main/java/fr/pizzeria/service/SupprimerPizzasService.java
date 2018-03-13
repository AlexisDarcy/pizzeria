package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * Classe permettant la supprimer d'une pizza
 * @author Alexis Darcy
 */
public class SupprimerPizzasService extends MenuService{

	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant de supprimer une pizza
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws DeletePizzaException {
		String codeRechercher;
		System.out.println("Suppression d’une pizza");
		for(Pizza p : lesPizzas.findAllPizzas()){
			System.out.println(p);
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
		codeRechercher = questionUser.nextLine();
		if(lesPizzas.pizzaExists(codeRechercher)){
			lesPizzas.deletePizza(codeRechercher);
		} else {
			throw new DeletePizzaException("La pizza n'existe déjà !!!");
		}
		lesPizzas.deletePizza(codeRechercher);
	}
}
