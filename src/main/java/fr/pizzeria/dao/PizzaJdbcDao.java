/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Alexis Darcy
 *
 */
public class PizzaJdbcDao implements IPizzaDao {
	
	/**connect : Connection Objet Connection*/
	private static Connection connect;

	public PizzaJdbcDao() {
		connect = ConnexionBDD.getConnexion();
	}

	public void close(){
		try {
			ConnexionBDD.close();
			connect.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#init()
	 */
	@Override
	public void init() {
		if(categorieIsEmpty()){
			initCategorie();
		}
		if(pizzaIsEmpty()){
			initPizza();
		}
	}
	

	public void initCategorie() {
		try {
			PreparedStatement insertCategorie = connect.prepareStatement("INSERT INTO categorie VALUES (?)"); 
			for(CategoriePizza newCat : CategoriePizza.values()){
				insertCategorie.setString(1, newCat.name());
				insertCategorie.executeUpdate();
			}
			insertCategorie.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initPizza() {
		List <Pizza> newPizzas = new ArrayList<Pizza>();
		newPizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		newPizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		newPizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		newPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		newPizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		newPizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		newPizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		newPizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
		try {
			PreparedStatement insertPizza = connect.prepareStatement("INSERT INTO pizza (CODE, LIBELLE, PRIX, CATEGORIE) VALUES (?, ?, ?, ?)");
			for(Pizza  newPizza : newPizzas){
				insertPizza.setString(1, newPizza.getCode());
				insertPizza.setString(2, newPizza.getLibelle());
				insertPizza.setDouble(3, newPizza.getPrix());
				insertPizza.setString(4, newPizza.getCategorie().name());
				insertPizza.executeUpdate();
			}
			insertPizza.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean pizzaIsEmpty(){
		boolean retour = true;
		try {
			Statement statement = connect.createStatement();
			ResultSet selectPizza = statement.executeQuery("SELECT COUNT(*) AS NB FROM pizza");
			if(selectPizza.next()){
				int nb = selectPizza.getInt("NB");
				if(nb != 0){
					retour = false;
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	

	public boolean categorieIsEmpty(){
		boolean retour = true;
		try {
			Statement statement = connect.createStatement();
			ResultSet selectCategorie = statement.executeQuery("SELECT COUNT(*) AS NB FROM categorie");
			if(selectCategorie.next()){
				int nb = selectCategorie.getInt("NB");
				if(nb != 0){
					retour = false;
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		List <Pizza> lesPizzas = new ArrayList<Pizza>();
		Statement statement;
		try {
			statement = connect.createStatement();
			ResultSet selectPizza = statement.executeQuery("SELECT ID_PIZZA, CODE, LIBELLE, PRIX, CATEGORIE FROM pizza");
			while(selectPizza.next()){
				int id = selectPizza.getInt("ID_PIZZA");
				String code = selectPizza.getString("CODE");
				String libelle = selectPizza.getString("LIBELLE");
				double prix = selectPizza.getDouble("PRIX");
				CategoriePizza categorie = CategoriePizza.valueOf(
						selectPizza.getString("CATEGORIE"));
				lesPizzas.add(new Pizza(id, code, libelle, prix, categorie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lesPizzas;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			PreparedStatement insertPizza = connect.prepareStatement("INSERT INTO pizza (CODE, LIBELLE, PRIX, CATEGORIE) VALUES (?, ?, ?, ?)");
			insertPizza.setString(1, pizza.getCode());
			insertPizza.setString(2, pizza.getLibelle());
			insertPizza.setDouble(3, pizza.getPrix());
			insertPizza.setString(4, pizza.getCategorie().name());
			insertPizza.executeUpdate();
			insertPizza.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try {
			PreparedStatement updatePizza = connect.prepareStatement("UPDATE pizza SET CODE = ?, LIBELLE = ?, PRIX = ?, CATEGORIE = ? WHERE CODE = ?");
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, pizza.getCategorie().name());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
			updatePizza.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza) {
		try {
			PreparedStatement deletePizza = connect.prepareStatement("DELETE FROM pizza WHERE CODE = ?");
			deletePizza.setString(1, codePizza);
			deletePizza.executeUpdate();
			deletePizza.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean retour = false;
		try {
			Statement statement = connect.createStatement();
			ResultSet selectPizza = statement.executeQuery("SELECT COUNT(*) AS NB FROM pizza WHERE CODE = '" + codePizza + "'");
			if(selectPizza.next()){
				int nb = selectPizza.getInt("NB");
				if(nb == 1){
					retour = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#categorieExists(java.lang.String)
	 */
	@Override
	public boolean categorieExists(String cat) {
		boolean retour = false;
		try {
			Statement statement = connect.createStatement();
			ResultSet selectCategorie = statement.executeQuery("SELECT COUNT(*) AS NB FROM categorie WHERE libelle = '" + cat + "'");
			if(selectCategorie.next()){
				int nb = selectCategorie.getInt("NB");
				if(nb == 1){
					retour = true;
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	

}
