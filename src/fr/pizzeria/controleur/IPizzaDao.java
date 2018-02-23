package fr.pizzeria.controleur;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	void init();
	List<Pizza>findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
