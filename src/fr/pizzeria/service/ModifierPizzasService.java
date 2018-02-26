package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzasService extends MenuService {
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws UpdatePizzaException {
		String code;
		String codeRechercher;
		String nom;
		double prix;
		System.out.println("Mise à jour d’une pizza");
		System.out.println("Veuillez choisir le code de la pizza à modifier : ");
		codeRechercher = questionUser.next();	
		
		if(lesPizzas.pizzaExists(codeRechercher)){
			System.out.println("Veuillez saisir le code : ");
			code = questionUser.next();
			System.out.println("Veuillez saisir le nom (sans espace) : ");
			nom = questionUser.next();
			System.out.println("Veuillez saisir le prix : ");
			prix = questionUser.nextDouble();
			lesPizzas.updatePizza(codeRechercher, new Pizza(code, nom, prix));
		}else{
			throw new UpdatePizzaException("La pizza n'existe pas !!!");
		}
	}
}
