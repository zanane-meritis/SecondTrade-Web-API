package fr.secondtrade.webapi.helpers;

import java.util.ArrayList;
import java.util.List;

public class Static {

	public Static(){

	}

	public static List<String> getErreursForException(Exception exception) { 
		// on récupère la liste des messages d'erreur de l'exception 
		Throwable cause = exception;
		List<String> erreurs = new ArrayList<String>();
		while (cause != null) {
			erreurs.add(cause.getMessage()); 
			cause = cause.getCause();
		}
		return erreurs; 
	}
}
