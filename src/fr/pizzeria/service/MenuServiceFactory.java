package fr.pizzeria.service;

public class MenuServiceFactory {
	public static MenuService getInstance(int choix) {
		MenuService mS = null;  
		
		switch (choix) {
		case 1:
			mS = new ListerPizzasService();
			break;
		case 2:
			mS = new AjouterPizzasService();
			break;
		case 3:
			mS = new ModifierPizzasService();
			break;
		case 4:
			mS = new SupprimerPizzasService();
			break;
		case 99:
			mS = new QuitterPizzaService();
			break;
		}
		return mS;	
	}
}
