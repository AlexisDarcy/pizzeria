/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alexis Darcy
 *
 */
public class ConnexionBDD {
	
	/**LOG : Logger*/
	private static final Logger LOG = LoggerFactory.getLogger(ConnexionBDD.class);
	 
	/**url : String driver de la base de donnée*/
	private String driver;
	/**url : String URL de connexion*/
	private String url;
	/**user : String Nom du user*/
	private String user;
	/**passwd : String Mot de passe de l'utilisateur*/
	private String password;
	
	/**connect : Connection Objet Connection*/
	private static Connection connect;
	
	/**singleton : ConnexionBDD*/
	private static ConnexionBDD singleton = null;
		
	/** Constructeur
	 * 
	 */
	private ConnexionBDD() {
		try {
			ResourceBundle resource = ResourceBundle.getBundle("jdbc");
			driver = resource.getString("jdbc.driverClassName");
			url = resource.getString("jdbc.url");
			user = resource.getString("jdbc.username");
			password = resource.getString("jdbc.password");
			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, password);
	    } catch (Exception e) {
	    	LOG.error("erreur de connexion : " + e.getMessage()); 
	    }
	}
	
	/**
	 * @return
	 */
	public static Connection getConnexion() {
		try {
			if (singleton == null || connect.isClosed()){ // si le singleton n'existe pas encore
				singleton = new ConnexionBDD(); // appel au constructeur privé
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	/**
	 * 
	 */
	public static void close() {
		try {
			if (singleton != null){
				connect.close();
				singleton=null;
			}
		} catch (Exception e) {
			LOG.error("erreur de déconnexion : " + e.getMessage()); 
			System.exit(-1);
		}
	}
	
}
