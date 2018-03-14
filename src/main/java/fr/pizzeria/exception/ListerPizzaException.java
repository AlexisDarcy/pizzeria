/**
 * 
 */
package fr.pizzeria.exception;

/**
 * @author Alexis Darcy
 *
 */
public class ListerPizzaException extends PizzaException {

	/**serialVersionUID : long*/
	private static final long serialVersionUID = -4369104617305647471L;

	/** Constructeur
	 * 
	 */
	public ListerPizzaException() {
		super();
	}

	/** Constructeur
	 * @param message
	 */
	public ListerPizzaException(String message) {
		super(message);
	}
}
