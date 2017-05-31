package servlet;

import java.util.HashMap;

public class Model{
	
	// Es wird eine Map erstellt und direkt mit den passenden Daten befüllt
	private static HashMap<String,String> map;
	static{
		map = new HashMap<>();
		map.put("Oberoesterreich", "Linz");
		map.put("Wien", "Wien");
		map.put("Niederoesterreich", "St. Poelten");
		map.put("Steiermark", "Graz");
		map.put("Vorarlberg", "Bregenz");
		map.put("Salzburg", "Salzburg");
		map.put("Kaernten", "Klagenfurt");
		map.put("Tirol", "Innsbruck");
		map.put("Burgenland", "Eisenstadt");
	}
	
	/**
	 * 
	 * @param state Das Bundesland zu welchem eine Haupstadt gesucht wird
	 * @return Die Hauptstadt passend zum Bundesland
	 */
	public static String getCapital(String state){
		return map.get(state);
	}
	
	/**
	 * 
	 * @return alle Hauptstädte
	 */
	public static String[] getHautpstaedte(){
		return map.values().toArray(new String[0]);
	}
	
	/**
	 * 
	 * @return alle Bundesländer
	 */
	public static String[] getBundesLaender(){
		return map.keySet().toArray(new String[0]);
	}
}