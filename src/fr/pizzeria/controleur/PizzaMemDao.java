package fr.pizzeria.controleur;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	List <Pizza> lesPizzas = new ArrayList<Pizza>();
	
	public PizzaMemDao() {
		super();
	}

	@Override
	public void init() {
		lesPizzas.add(new Pizza("PEP", "P�p�roni", 12.50));
		lesPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		lesPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		lesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		lesPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		lesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		lesPizzas.add(new Pizza("ORI", "L�orientale", 13.50));
		lesPizzas.add(new Pizza("IND", "L�indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return lesPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}