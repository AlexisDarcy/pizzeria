package fr.pizzeria.service;

import fr.pizzeria.exception.PizzaException;

/**
 * Factory Qui retourne une instance de {@link MenuService}
 * @author ETY0009
 *
 */
public class MenuServiceFactory {
	
	/**
	 * Redirige vers le bon service est throws l'execption via la class PizzaException
	 * @param choix
	 * @return MenuService
	 * @throws PizzaException
	 */
	public static MenuService getInstance(int choix) throws PizzaException {
		MenuService mS = null;  
		
		switch (choix) {
		case 1:
			mS = new ListerPizzasService();
			break;
		case 2:
			mS = new AjouterPizzasService();
			break;
		case 3:
			mS = new ModifierPizzasService();
			break;
		case 4:
			mS = new SupprimerPizzasService();
			break;
		case 99:
			mS = new QuitterPizzaService();
			break;
		default :
			throw new PizzaException("Une erreur est survenu lors de la saisie");
		}
		return mS;	
	}
	
}
