package fr.pizzeria.exception;
/**Classe permettant le gestion des erreurs des pizzas
 * @author Alexis Darcy
 *
 */
public class PizzaException extends Exception {
	
	/**serialVersionUID : long*/
	private static final long serialVersionUID = -6555897837598044715L;

	/** Constructeur
	 * 
	 */
	public PizzaException() {
		super();
	}

	/** Constructeur
	 * @param message
	 */
	public PizzaException(String message) {
		super(message);
	}
}
