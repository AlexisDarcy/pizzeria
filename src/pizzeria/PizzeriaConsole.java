package pizzeria;

import java.util.Scanner;

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
			reponse(reponse, lesPizzas, questionUser);
			
		}while(reponse != 99);
		
		questionUser.close();
		
	}
	
	public static void initPizza(Pizza [] lesPizzas){
		Pizza p1 = new Pizza("PEP", "Pépéroni", 12.50);
		lesPizzas[0] = p1;
		Pizza p2 = new Pizza("MAR", "Margherita", 14.00);
		lesPizzas[1] = p2;
		Pizza p3 = new Pizza("REIN", "La Reine", 11.50);
		lesPizzas[2] = p3;
		Pizza p4 = new Pizza("FRO", "La 4 fromages", 12.00);
		lesPizzas[3] = p4;
		Pizza p5 = new Pizza("CAN", "La cannibale", 12.50);
		lesPizzas[4] = p5;
		Pizza p6 = new Pizza("SAV", "La savoyarde", 13.00);
		lesPizzas[5] = p6;
		Pizza p7 = new Pizza("ORI", "L’orientale", 13.50);
		lesPizzas[6] = p7;
		Pizza p8 = new Pizza("IND", "L’indienne", 14.00);
		lesPizzas[7] = p8;
	}
	
	public static void afficherMenu(){
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public static void reponse(int r, Pizza [] lesPizzas, Scanner questionUser){
		String code;
		String nom;
		double prix;
		boolean trouver = false;
		int j = 0;
		switch (r) {
		case 1:
			System.out.println("Liste des pizzas");
			for(int i = 0; i < Pizza.getCompteur() ; i++){
				if(lesPizzas[i] != null){
					System.out.println(lesPizzas[i]);
				}
			};
			break;
		case 2:
			System.out.println("Ajout d’une nouvelle pizza\n");
			System.out.println("Veuillez saisir le code : ");
			code = questionUser.next();
			System.out.println("Veuillez saisir le nom (sans espace) : ");
			nom = questionUser.next();
			System.out.println("Veuillez saisir le prix : ");
			prix = questionUser.nextDouble();
			lesPizzas[Pizza.getCompteur()] = new Pizza(code, nom, prix);
			break;
		case 3:
			System.out.println("Mise à jour d’une pizza");
			System.out.println("Veuillez choisir le code de la pizza à modifier : ");
			code = questionUser.next();
			
			do{
				if(code.equals(lesPizzas[j].getCode())){
					System.out.println("Veuillez saisir le code : ");
					lesPizzas[j].setCode(questionUser.next());
					System.out.println("Veuillez saisir le nom (sans espace) : ");
					lesPizzas[j].setLibelle(questionUser.next());
					System.out.println("Veuillez saisir le prix : ");
					lesPizzas[j].setPrix(questionUser.nextDouble());
					trouver = true;
				}
				j++;
			}while(trouver == false);
			break;
		case 4:
			System.out.println("Suppression d’une pizza");
			for(int i = 0; i < Pizza.getCompteur() ; i++){
				if(lesPizzas[i] != null){
					System.out.println(lesPizzas[i]);
				}
			};
			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
			code = questionUser.next();
			do{
				if(code.equals(lesPizzas[j].getCode())){
					lesPizzas[j] = null;
					trouver = true;
				}
				j++;
			}while(trouver == false);
			break;
		case 99:
			System.out.println("Aurevoir ☹");
			break;
		}	
	}
}
