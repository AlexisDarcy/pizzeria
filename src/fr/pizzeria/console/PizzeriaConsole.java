package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzeriaConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int reponse;
		Pizza [] lesPizzas = new Pizza[100];
		Scanner questionUser = new Scanner(System.in);
		
		initPizza(lesPizzas);
		
		do{
			
			afficherMenu();
			reponse = questionUser.nextInt();
//			reponse(reponse, lesPizzas, questionUser);
			
		}while(reponse != 99);
		
		questionUser.close();
		
	}
	
	public static void initPizza(Pizza [] lesPizzas){
		lesPizzas[0] = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		lesPizzas[1] = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		lesPizzas[2] = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		lesPizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		lesPizzas[4] = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		lesPizzas[5] = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		lesPizzas[6] = new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.VIANDE);
		lesPizzas[7] = new Pizza("IND", "L’indienne", 14.00, CategoriePizza.POISSON);
	}
	
	public static void afficherMenu(){
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
//	public static void reponse(int r, Pizza [] lesPizzas, Scanner questionUser){
//		String code;
//		String nom;
//		double prix;
//		boolean trouver = false;
//		int j = 0;
//		switch (r) {
//		case 1:
//			System.out.println("Liste des pizzas");
//			for(int i = 0; i < Pizza.getCompteur() ; i++){
//				if(lesPizzas[i] != null){
//					System.out.println(lesPizzas[i]);
//				}
//			};
//			break;
//		case 2:
//			System.out.println("Ajout d’une nouvelle pizza\n");
//			System.out.println("Veuillez saisir le code : ");
//			code = questionUser.next();
//			System.out.println("Veuillez saisir le nom (sans espace) : ");
//			nom = questionUser.next();
//			System.out.println("Veuillez saisir le prix : ");
//			prix = questionUser.nextDouble();
//			lesPizzas[Pizza.getCompteur()] = new Pizza(code, nom, prix);
//			break;
//		case 3:
//			System.out.println("Mise à jour d’une pizza");
//			System.out.println("Veuillez choisir le code de la pizza à modifier : ");
//			code = questionUser.next();
//			
//			do{
//				if(code.equals(lesPizzas[j].getCode())){
//					System.out.println("Veuillez saisir le code : ");
//					lesPizzas[j].setCode(questionUser.next());
//					System.out.println("Veuillez saisir le nom (sans espace) : ");
//					lesPizzas[j].setLibelle(questionUser.next());
//					System.out.println("Veuillez saisir le prix : ");
//					lesPizzas[j].setPrix(questionUser.nextDouble());
//					trouver = true;
//				}
//				j++;
//			}while(trouver == false);
//			break;
//		case 4:
//			System.out.println("Suppression d’une pizza");
//			for(int i = 0; i < Pizza.getCompteur() ; i++){
//				if(lesPizzas[i] != null){
//					System.out.println(lesPizzas[i]);
//				}
//			};
//			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
//			code = questionUser.next();
//			do{
//				if(code.equals(lesPizzas[j].getCode())){
//					lesPizzas[j] = null;
//					trouver = true;
//				}
//				j++;
//			}while(trouver == false);
//			break;
//		case 99:
//			System.out.println("Aurevoir ☹");
//			break;
//		}	
//	}
}
