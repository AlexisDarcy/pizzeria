package pizzeria;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza [] lesPizzas = new Pizza[8];
		int reponse;
		Scanner questionUser = new Scanner(System.in);
		
		initPizza(lesPizzas);
		
		do{
			afficherMenu();
			
			reponse = questionUser.nextInt();
			
			reponse(reponse, lesPizzas);
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
		Pizza p6 = new Pizza("CAN", "La savoyarde", 13.00);
		lesPizzas[5] = p6;
		Pizza p7 = new Pizza("CAN", "L’orientale", 13.50);
		lesPizzas[6] = p7;
		Pizza p8 = new Pizza("CAN", "L’indienne", 14.00);
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
	
	public static void reponse(int r, Pizza [] lesPizzas){
		switch (r) {
		case 1:
			System.out.println("Liste des pizzas");
			for(int i = 0; i < lesPizzas.length; i++){
				System.out.println(lesPizzas[i].getCode() + " -> " + lesPizzas[i].getLibelle() + " ( " + lesPizzas[i].getPrix() + " € ) ");
			};
			break;
		case 2:
			System.out.println("Ajout d’une nouvelle pizza");
			break;
		case 3:
			System.out.println("Mise à jour d’une pizza");
			break;
		case 4:
			System.out.println("Suppression d’une pizza");
			break;
		case 99:
			System.out.println("Aurevoir ☹");
			break;
		}	
	}
}
