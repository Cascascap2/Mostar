package beans;

import java.util.Date;
import java.util.Set;

import logica.modelos.Contenido;

public class userController {
	
	String nickname;

	String mail;

	String password;
	
	Set<Contenido> favorites;
	
	Double wallet;

	Date DateExpiration;
	
	int PermissionId;
	
	boolean isLogged;
	
	
}
