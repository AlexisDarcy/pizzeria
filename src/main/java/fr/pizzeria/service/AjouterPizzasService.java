package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * Classe permettant l'ajout d'une pizza
 * @author Alexis Darcy
 */
public class AjouterPizzasService extends MenuService {
	
	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant l'ajout d'une pizza
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 * @throws SavePizzaException
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws SavePizzaException {
		String code;
		String nom;
		String strPrix;
		String strCat;
		CategoriePizza cat;
		double prix;
		try{
			System.out.println("Ajout d’une nouvelle pizza\n");
			System.out.println("Veuillez saisir le code : ");
			code = questionUser.nextLine();
			System.out.println("Veuillez saisir le nom (sans espace) : ");
			nom = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix : ");
			strPrix = questionUser.nextLine().replaceFirst(",", ".");
			prix = Double.parseDouble(strPrix);
			System.out.println("Veuillez saisir une categorie : ");
			strCat = questionUser.nextLine().toUpperCase().trim();
			cat = CategoriePizza.valueOf(strCat.replaceFirst(" ", "_"));
			if(lesPizzas.categorieExists(cat)){
				if(!lesPizzas.pizzaExists(code)){
					lesPizzas.saveNewPizza(new Pizza(code, nom, prix, cat));
				} else {
					throw new SavePizzaException("La pizza existe déjà");
				}
			} else {
				throw new SavePizzaException("La catégorie n'existe déjà");
			}

		} catch (NumberFormatException e) {
			System.err.println("Une erreur est survenu lors de la saisie");
		}
	}
}
