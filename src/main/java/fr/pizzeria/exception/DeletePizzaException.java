package fr.pizzeria.exception;
/**Classe permettant le gestion des erreurs lors de la suppression des pizzas
 * @author Alexis Darcy
 * 
 */
public class DeletePizzaException extends PizzaException {

	/**serialVersionUID : long*/
	private static final long serialVersionUID = -205480846048285884L;

	/** Constructeur
	 * 
	 */
	public DeletePizzaException() {
		super();
	}

	/** Constructeur
	 * @param message
	 */
	public DeletePizzaException(String message) {
		super(message);
	}

}
