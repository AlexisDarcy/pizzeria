package fr.pizzeria.model;
/**
 * enumeration de categorie de pizza
 * @author Alexis Darcy
 *
 */
public enum CategoriePizza {
		VIANDE ("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
		/**cat : String*/
		private String categorie;

		/** Constructeur
		 * @param cat
		 */
		private CategoriePizza(String cat) {
			this.categorie = cat;
		}

		/** Getter
		 * @return the cat
		 */
		public String getCategorie() {
			return categorie;
		}
}
