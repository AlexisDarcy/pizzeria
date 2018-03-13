package fr.pizzeria.exception;
/**Classe permettant le gestion des erreurs lors de la modification d'une pizza
 * @author Alexis Darcy
 * 
 */
public class UpdatePizzaException extends PizzaException {

	/**serialVersionUID : long*/
	private static final long serialVersionUID = 8702769028656955569L;

	/** Constructeur
	 * 
	 */
	public UpdatePizzaException() {
		super();
	}

	/** Constructeur
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
	}

}
