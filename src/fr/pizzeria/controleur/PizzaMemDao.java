package fr.pizzeria.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private List <Pizza> lesPizzas = new ArrayList<Pizza>();
	
	public PizzaMemDao() {
		super();
	}

	@Override
	public void init() {
		lesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		lesPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		lesPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		lesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		lesPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		lesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		lesPizzas.add(new Pizza("ORI", "L’orientale", 13.50));
		lesPizzas.add(new Pizza("IND", "L’indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return lesPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		lesPizzas.add(pizza);
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza p = null;
		p = findPizzaByCode(codePizza);
		p.setCode(pizza.getCode());
		p.setLibelle(pizza.getLibelle());
		p.setPrix(pizza.getPrix());
	}

	@Override
	public void deletePizza(String codePizza) {
		Iterator<Pizza> iterator = lesPizzas.iterator(); 
		
		while (iterator.hasNext()){
			Pizza p = iterator.next();
			if(p.getCode().equals(codePizza)){
				iterator.remove();
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaTrouver = null;
		Iterator<Pizza> iterator = lesPizzas.iterator(); 
		
		while (iterator.hasNext()){
			Pizza p = iterator.next();
			if(p.getCode().equals(codePizza)){
				pizzaTrouver = p;
			}
		}
		
		return pizzaTrouver;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean trouver = false;
		Iterator<Pizza> iterator = lesPizzas.iterator(); 
		
		while (iterator.hasNext()){
			Pizza p = iterator.next();
			if(p.getCode().equals(codePizza)){
				trouver = true;
			}
		}
		return trouver;
	}

}
