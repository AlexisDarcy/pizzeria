package pizzeria;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.controleur.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzeriaConsole2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int reponse;
		PizzaMemDao lesPizzas = new PizzaMemDao();
		Scanner questionUser = new Scanner(System.in);
		
		lesPizzas.init();
		
		do{
			
			afficherMenu();
			reponse = questionUser.nextInt();
			reponse(reponse, lesPizzas, questionUser);
			
		}while(reponse != 99);
		
		questionUser.close();
		
	}
	
	public static void initPizza(List <Pizza> lesPizzas){
		lesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		lesPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		lesPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		lesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		lesPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		lesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		lesPizzas.add(new Pizza("ORI", "L’orientale", 13.50));
		lesPizzas.add(new Pizza("IND", "L’indienne", 14.00));
	}
	
	public static void afficherMenu(){
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public static void reponse(int r, PizzaMemDao lesPizzas, Scanner questionUser){
		String code;
		String nom;
		double prix;
		boolean trouver = false;
		int j = 0;
		switch (r) {
		case 1:
			System.out.println("Liste des pizzas");
			for(Pizza p : lesPizzas.findAllPizzas()){
					System.out.println(p);
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
			lesPizzas.findAllPizzas().add(new Pizza(code, nom, prix));
			break;
		case 3:
			System.out.println("Mise à jour d’une pizza");
			System.out.println("Veuillez choisir le code de la pizza à modifier : ");
			code = questionUser.next();
			
			do{
				if(code.equals(lesPizzas.findAllPizzas().get(j).getCode())){
					System.out.println("Veuillez saisir le code : ");
					lesPizzas.findAllPizzas().get(j).setCode(questionUser.next());
					System.out.println("Veuillez saisir le nom (sans espace) : ");
					lesPizzas.findAllPizzas().get(j).setLibelle(questionUser.next());
					System.out.println("Veuillez saisir le prix : ");
					lesPizzas.findAllPizzas().get(j).setPrix(questionUser.nextDouble());
					trouver = true;
				}
				j++;
			}while(trouver == false);
			break;
		case 4:
			System.out.println("Suppression d’une pizza");
			for(Pizza p : lesPizzas.findAllPizzas()){
				System.out.println(p);
		};
			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
			code = questionUser.next();
			do{
				if(code.equals(lesPizzas.findAllPizzas().get(j).getCode())){
					lesPizzas.findAllPizzas().remove(j);
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
