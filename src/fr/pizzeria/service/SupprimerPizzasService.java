package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzasService extends MenuService{
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws DeletePizzaException {
		String codeRechercher;
		System.out.println("Suppression d’une pizza");
		for(Pizza p : lesPizzas.findAllPizzas()){
			System.out.println(p);
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
		codeRechercher = questionUser.next();
		if(lesPizzas.pizzaExists(codeRechercher)){
			lesPizzas.deletePizza(codeRechercher);
		} else {
			throw new DeletePizzaException("La pizza n'existe déjà !!!");
		}
		lesPizzas.deletePizza(codeRechercher);
	}
}
