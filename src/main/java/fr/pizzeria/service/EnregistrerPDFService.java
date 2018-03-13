/**
 * 
 */
package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.utils.PDFGenerator;

/**
 * Classe permettant de créer un pdf
 * @author Alexis Darcy
 */
public class EnregistrerPDFService extends MenuService {

	/**
	 * redefinition de la classe executeUC de la classe 
	 * {@link MenuService} permettant de créer un pdf
	 * @param lesPizzas : IPizzaDao
	 * @param questionUser : Scanner
	 * @throws SavePizzaException
	 */
	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws PizzaException {
		System.out.println("Creation du PDF");
		PDFGenerator.PDFCreator(lesPizzas.findAllPizzas());
		System.out.println("Fini");
	}
	
}
