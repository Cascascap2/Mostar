package controladores;

import java.util.Date;

import logica.modelos.Contenido;
import logica.modelos.Usuario;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		Date expdate = new Date();
		
		Manejador manejador = Manejador.getInstance();
		UsuarioControlador uc = manejador.getUsuarioControlador();
		ContenidoControlador cc = manejador.getContenidoControlador();
		CategoriaControlador cac = manejador.getCategoriaControlador();
		
		cac.altaCategoria("Terror");
		
		//uc.registrarUsuario("testing", "testing2@mail.com", "testpass", 250.50, expdate, 3);		
		//cc.altaContenido("ContenidoTest", "HBO");
		
		//Usuario user = uc.getUsuario("testing");
		//Contenido con = cc.getContenido("ContenidoTest");
		
		//uc.agregarFavorito(user, con);
		
		//uc.borrarUsuario("testing");		
		//cc.borrarContenido("ContenidoTest");
	}

}
