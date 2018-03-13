package fr.pizzeria.model;

import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

/**
 * Objet pizza
 * @author Alexis Darcy
 *
 */
public class Pizza {
	
	/**id : int*/
	private int id;
	/**code : String*/
	@ToString(separateur = " -> ", upperCase = true )
	private String code;
	/**libelle : String*/
	@ToString (separateur = " (", upperCase = true )
	private String libelle;
	/**prix : double*/
	@ToString(separateur = " €) -> ", upperCase = false)
	private double prix;
	/**compteur : int*/
	private static int compteur = 0;
	/**categorie : CategoriePizza*/
	@ToString(separateur = ".",  upperCase = false)
	private CategoriePizza categorie;
	
	/**
	 * Constructeur
	 * @param code chaine de characteur
	 * @param libelle chaine de characteur
	 * @param prix reel
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		super();
		this.id = compteur;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		compteur++;
	}
	
	/**
	 * Constructeur
	 * @param id entier
	 * @param code chaine de characteur
	 * @param libelle chaine de characteur
	 * @param prix reel
	 */
	public Pizza(int id, String code, String libelle, double prix,  CategoriePizza categorie) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/** Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/** Getter
	 * @return the compteur
	 */
	public static int getCompteur() {
		return compteur;
	}

	/** Getter
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * Methode toString Redefini
	 */
	@Override
	public String toString() {
		return StringUtils.getStringValue(this);
	}
	
}
