package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * Classe permettant la modification d'une pizza
 * @author Alexis Darcy
 */
public class ModifierPizzasService extends MenuService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ModifierPizzasService.class);
	
	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant la modification d'une pizza
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 * @throws UpdatePizzaException
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws UpdatePizzaException {
		String code;
		String codeRechercher;
		String nom;
		String strPrix;
		String strCat;
		CategoriePizza cat;
		double prix;
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisir le code de la pizza à modifier : ");
		codeRechercher = questionUser.nextLine();	
		try{
			if(lesPizzas.pizzaExists(codeRechercher)){
				System.out.println("Veuillez saisir le code : ");
				code = questionUser.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace) : ");
				nom = questionUser.nextLine();
				System.out.println("Veuillez saisir le prix : ");
				strPrix = questionUser.nextLine().replaceFirst(",", ".");
				prix = Double.parseDouble(strPrix);
				System.out.println("Veuillez saisir une categorie : ");
				strCat = questionUser.nextLine().toUpperCase().trim();
				strCat = strCat.replaceFirst(" ", "_");
				if(lesPizzas.categorieExists(strCat)){
					cat = CategoriePizza.valueOf(strCat);
					lesPizzas.updatePizza(codeRechercher, new Pizza(code, nom, prix, cat));
				} else {
					LOG.error("La catégorie n'existe pas");
					throw new UpdatePizzaException("La catégorie n'existe pas");
				}
			}else{
				LOG.error("La pizza n'existe pas !!!");
				throw new UpdatePizzaException("La pizza n'existe pas !!!");
			}

		} catch (NumberFormatException e) {
			LOG.error("Une erreur est survenu lors de la saisie");
			throw new UpdatePizzaException("Une erreur est survenu lors de la saisie");
		}
	}
}
