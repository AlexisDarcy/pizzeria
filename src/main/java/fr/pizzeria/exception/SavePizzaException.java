package fr.pizzeria.exception;
/**Classe permettant le gestion des erreurs lors de l'ajout d'une pizza
 * @author Alexis Darcy
 * 
 */
public class SavePizzaException extends PizzaException {

	/**serialVersionUID : long*/
	private static final long serialVersionUID = -2346475209618282430L;

	/** Constructeur
	 * 
	 */
	public SavePizzaException() {
		super();
	}

	/** Constructeur
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}

}
