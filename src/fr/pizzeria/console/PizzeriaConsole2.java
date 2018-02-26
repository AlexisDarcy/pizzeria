package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

public class PizzeriaConsole2 {

	public static void main(String[] args) {
		int reponse;
		IPizzaDao lesPizzas = new PizzaMemDao();
		Scanner questionUser = new Scanner(System.in);
		
		lesPizzas.init();
		
		do{
			
			afficherMenu();
			reponse = questionUser.nextInt();
			MenuService mS = MenuServiceFactory.getInstance(reponse);
			mS.executeUC(lesPizzas, questionUser);
			
		}while(reponse != 99);
		
		questionUser.close();
		
	}
	
	public static void afficherMenu(){
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
//	public static void reponse(int r, IPizzaDao lesPizzas, Scanner questionUser){
//		String code;
//		String codeRechercher;
//		String nom;
//		double prix;
//		switch (r) {
//			case 1:
//				System.out.println("Liste des pizzas");
//				for(Pizza p : lesPizzas.findAllPizzas()){
//						System.out.println(p);
//				};
//				break;
//			case 2:
//				System.out.println("Ajout d’une nouvelle pizza\n");
//				System.out.println("Veuillez saisir le code : ");
//				code = questionUser.next();
//				System.out.println("Veuillez saisir le nom (sans espace) : ");
//				nom = questionUser.next();
//				System.out.println("Veuillez saisir le prix : ");
//				prix = questionUser.nextDouble();
//				lesPizzas.saveNewPizza(new Pizza(code, nom, prix));;
//				break;
//			case 3:
//				System.out.println("Mise à jour d’une pizza");
//				System.out.println("Veuillez choisir le code de la pizza à modifier : ");
//				codeRechercher = questionUser.next();	
//				System.out.println("Veuillez saisir le code : ");
//				code = questionUser.next();
//				System.out.println("Veuillez saisir le nom (sans espace) : ");
//				nom = questionUser.next();
//				System.out.println("Veuillez saisir le prix : ");
//				prix = questionUser.nextDouble();
//				lesPizzas.updatePizza(codeRechercher, new Pizza(code, nom, prix));
//				break;
//			case 4:
//				System.out.println("Suppression d’une pizza");
//				for(Pizza p : lesPizzas.findAllPizzas()){
//					System.out.println(p);
//				};
//				System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
//				codeRechercher = questionUser.next();
//				lesPizzas.deletePizza(codeRechercher);
//				break;
//			case 99:
//				System.out.println("Aurevoir ☹");
//				break;
//		}	
//	}
}
