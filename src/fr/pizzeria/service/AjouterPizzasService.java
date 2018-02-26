package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.controleur.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzasService extends MenuService {
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		String code;
		String nom;
		double prix;
		System.out.println("Ajout d’une nouvelle pizza\n");
		System.out.println("Veuillez saisir le code : ");
		code = questionUser.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		nom = questionUser.next();
		System.out.println("Veuillez saisir le prix : ");
		prix = questionUser.nextDouble();
		lesPizzas.saveNewPizza(new Pizza(code, nom, prix));;
	}
}
