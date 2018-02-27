/**
 * 
 */
package fr.pizzeria.utils;

import java.lang.reflect.Field;

/**
 * @author Alexis Darcy
 *
 */
public class StringUtils {
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
