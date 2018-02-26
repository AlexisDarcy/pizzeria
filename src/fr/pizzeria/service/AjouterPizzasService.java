package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzasService extends MenuService {
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws SavePizzaException {
		String code;
		String nom;
		String strPrix;
		double prix;
		try{
			System.out.println("Ajout d’une nouvelle pizza\n");
			System.out.println("Veuillez saisir le code : ");
			code = questionUser.next();
			System.out.println("Veuillez saisir le nom (sans espace) : ");
			nom = questionUser.next();
			System.out.println("Veuillez saisir le prix : ");
			strPrix = questionUser.next();
			prix = Double.parseDouble(strPrix);
			if(!lesPizzas.pizzaExists(code)){
				lesPizzas.saveNewPizza(new Pizza(code, nom, prix));
			} else {
				throw new SavePizzaException("La pizza existe déjà");
			}
		} catch (NumberFormatException e) {
			System.err.println("Une erreur est survenu lors de la saisie");
		}
	}
}
