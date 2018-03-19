package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * 
 * @author Alexis Darcy
 *
 */
public class PizzaMemDao implements IPizzaDao {

	/**lesPizzas : List<Pizza>*/
	private List <Pizza> lesPizzas = new ArrayList<Pizza>();
	
	/** Constructeur  */
	public PizzaMemDao() {
		super();
	}
	
	@Override
	public void init() {
		lesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		lesPizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		lesPizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		lesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		lesPizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		lesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		lesPizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		lesPizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
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
		p.setCategorie(pizza.getCategorie());
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

	@Override
	public boolean categorieExists(String strCat) {
		boolean trouver = false;
		CategoriePizza[] tabCat = CategoriePizza.values(); 
		List<CategoriePizza> listCat = new ArrayList<CategoriePizza>(Arrays.asList(tabCat));
		Iterator<CategoriePizza> iterator = listCat.iterator(); 
		while (iterator.hasNext()){
			CategoriePizza cat = iterator.next();
			if(cat.name().equals(strCat)){
				trouver = true;
			}
		}
		return trouver;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
