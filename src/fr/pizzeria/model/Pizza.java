package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	static int auto = 0;
	
	public Pizza(String code, String libelle, double prix) {
		super();
		this.id = auto;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		auto++;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
}
