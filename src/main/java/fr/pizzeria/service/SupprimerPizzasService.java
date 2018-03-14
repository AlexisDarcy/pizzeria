package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * Classe permettant la supprimer d'une pizza
 * @author Alexis Darcy
 */
public class SupprimerPizzasService extends MenuService{

	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzasService.class);
	
	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant de supprimer une pizza
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws DeletePizzaException {
		String codeRechercher;
		System.out.println("Suppression d'une pizza");
		for(Pizza p : lesPizzas.findAllPizzas()){
			System.out.println(p);
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
		codeRechercher = questionUser.nextLine();
		if(lesPizzas.pizzaExists(codeRechercher)){
			lesPizzas.deletePizza(codeRechercher);
		} else {
			LOG.error("La pizza n'existe pas !!!");
			throw new DeletePizzaException("La pizza n'existe pas !!!");
		}
		lesPizzas.deletePizza(codeRechercher);
	}
}
