package controladores;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;

import javassist.bytecode.Descriptor.Iterator;
import logica.modelos.Contenido;
import logica.modelos.Favorito;
import logica.modelos.Usuario;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		Date expdate = new Date();
		UsuarioControlador uc = new UsuarioControlador();
		uc.registrarUsuario("testing", "testing@mail.com", "testpass",
							250.50, expdate, 3);
		
		
		System.out.println("Usuario de prueba creado con exito");
		//uc.borrarUsuario("testing");
		//System.out.println("Usuario de prueba borrado con exito");
		//Usuario user = uc.getUsuario("testing");
		//System.out.println("User: " + user.getNickname() + " of id: " + user.getId());
	}

}
