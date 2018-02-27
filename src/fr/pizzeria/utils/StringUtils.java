/**
 * 
 */
package fr.pizzeria.utils;

import java.lang.reflect.Field;

/**
 * @author Alexis Darcy
 *
 */
public final class StringUtils {
	
	/** Constructeur bloqué car classe s
	 * 
	 */
	private StringUtils() {
		super();
	}

	/**Méthode qui convertie un objet en chaine de caractères.<br>
	 * Cette conversion est fait sur la base de l'annotation @ToString
	 * @param object  : Object a convertir
	 * @return String
	 */
	public static String getStringValue(Object object) {
		String chaine = "";
		try{
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field f : fields){
				f.setAccessible(true);
				if(f.isAnnotationPresent(ToString.class)){
					ToString annotation = f.getAnnotation(ToString.class);
					Object value = f.get(object);
					if(!annotation.separateur().equals("")){
						value += annotation.separateur();
					} 
					if(annotation.upperCase()){	
						value = value.toString().toUpperCase();
					}
					chaine += value;
				}
			}
			return chaine;
		} catch (Exception e) {
			return null;
		}
	}
}
