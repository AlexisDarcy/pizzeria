/**
 * 
 */
package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.utils.PDFGenerator;

/**
 * @author Alexis Darcy
 *
 */
public class EnregistrerPDFService extends MenuService {


	@Override
	public void executeUC(IPizzaDao lesPizzas, Scanner questionUser) throws PizzaException {
		System.out.println("Creation du PDF");
		PDFGenerator.PDFCreator(lesPizzas.findAllPizzas());
		System.out.println("Fini");
	}
	
}
