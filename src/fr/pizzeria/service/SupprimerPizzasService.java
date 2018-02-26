package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.controleur.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzasService extends MenuService{
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) {
		String codeRechercher;
		System.out.println("Suppression d’une pizza");
		for(Pizza p : lesPizzas.findAllPizzas()){
			System.out.println(p);
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
		codeRechercher = questionUser.next();
		lesPizzas.deletePizza(codeRechercher);
	}
}
