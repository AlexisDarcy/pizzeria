package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe permettant l'ajout d'une pizza
 * @author Alexis Darcy
 */
public class AjouterPizzasService extends MenuService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzasService.class);
	
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
			System.out.println("Ajout d'une nouvelle pizza\n");
			System.out.println("Veuillez saisir le code : ");
			code = questionUser.nextLine();
			System.out.println("Veuillez saisir le nom (sans espace) : ");
			nom = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix : ");
			strPrix = questionUser.nextLine().replaceFirst(",", ".");
			prix = Double.parseDouble(strPrix);
			System.out.println("Veuillez saisir une categorie : ");
			strCat = questionUser.nextLine().toUpperCase().trim();
			strCat = (strCat.replaceFirst(" ", "_"));
			if(lesPizzas.categorieExists(strCat)){
				cat = CategoriePizza.valueOf(strCat);
				if(!lesPizzas.pizzaExists(code)){
					lesPizzas.saveNewPizza(new Pizza(code, nom, prix, cat));
				} else {
					LOG.error("La pizza existe déjà");
					throw new SavePizzaException("La pizza existe déjà");
				}
			} else {
				LOG.error("La catégorie n'existe pas");
				throw new SavePizzaException("La catégorie n'existe pas");
			}

		} catch (NumberFormatException e) {
			LOG.error("erreur dans la saisie du prix");
			throw new SavePizzaException("erreur dans la saisie du prix");
		}
	}
}
